package org.cointracker.transaction.fetch;

import org.cointracker.transaction.client.EthClient;
import org.cointracker.transaction.client.EthClientFactory;
import org.cointracker.transaction.client.TransactionsRequest;
import org.cointracker.transaction.model.EthTransaction;
import org.cointracker.transaction.model.TransactionType;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the transactions in batches for a given walletAddress and transactionType.
 * The TransactionsRequest Object is used to store the state of a given batch.
 * @param <T>
 */
public class TransactionsFetcher<T extends EthTransaction> {

    private final Logger logger;

    private final String walletAddress;
    private final TransactionType transactionType;

    private final TransactionsRequest request;
    private final EthClient<T> ethClient;

    private final Consumer<List<T>> transactionsConsumer;

    private int errorCounter = 0;
    private static final int ERROR_THRESHOLD = 3;
    private boolean done;

    /**
     *
     * @param walletAddress The String wallet address
     * @param transactionType The enum Transaction Type
     * @param transactionsConsumer A Consumer Function that takes the List of Transactions as Input
     */
    public TransactionsFetcher(String walletAddress, TransactionType transactionType,
                               Consumer<List<T>> transactionsConsumer) {
        this.walletAddress = walletAddress;
        this.transactionType = transactionType;
        this.logger = Logger.getGlobal();
        this.request = new TransactionsRequest();
        EthClientFactory ethClientFactory = new EthClientFactory();
        this.ethClient = ethClientFactory.create(transactionType);
        this.transactionsConsumer = transactionsConsumer;
        this.done = false;
    }

    /**
     * Fetch transactions from the API for a given Wallet Address and store state
     */
    public void fetchTransactions() {
        try {
            List<T> transactions = fetchTransactionsFromAPI();
            if (transactions == null) {
                logger.log(Level.SEVERE,
                        String.format("Did not receive Transactions from API for walletAddress %s, transactionType %s and request %s",
                                walletAddress, transactionType, request));

                // avoid looping for the same transactions request if more tha three errors
                errorCounter++;
                if (errorCounter > ERROR_THRESHOLD) {
                    setComplete();
                }
                return;
            }

            if (transactionsConsumer != null) {
                transactionsConsumer.accept(transactions);
            }
            if (!updateTransactionsRequest(transactions)) {
                setComplete();
            }

        } catch(Exception e) {
            String errMsg = String.format("Error executing task for walletAddress %s and transactionType %s and request %s" ,
                    walletAddress, transactionType, request);
            logger.log(Level.SEVERE, errMsg);
        }
    }

    public boolean isDone() {
        return done;
    }

    private void setComplete() {
        this.done = true;
    }

    private List<T> fetchTransactionsFromAPI() {
        List<T> transactions = this.ethClient.getTransactions(walletAddress, request);
        logger.log(Level.INFO,
                String.format("Received %s Transactions from API for walletAddress %s, transactionType %s and request %s",
                        transactions != null ? transactions.size() : null,
                        walletAddress, transactionType, request));

        return transactions;
    }

    /**
     * Takes the response from prev batch and determines if the next batch needs to be executed
     * @param transactions List of transactions form current batch
     * @return true if next batch exists
     *         false if all transactions are fetched
     */
    private boolean updateTransactionsRequest(List<T> transactions) {
        if (transactions.size() < request.getOffset()) {
            logger.log(Level.INFO,
                    String.format("All transactions fetched for wallet %s, transactionType %s and request %s",
                            walletAddress, transactionType, request));
            return false;
        }

        String nextBlockNumber = transactions.getLast().getBlockNumber();
        request.setStartBlock(nextBlockNumber);
        return true;
    }
}
