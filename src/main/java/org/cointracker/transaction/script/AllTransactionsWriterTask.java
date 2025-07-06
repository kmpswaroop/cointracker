package org.cointracker.transaction.script;

import org.cointracker.transaction.model.EthTransaction;
import org.cointracker.transaction.model.TransactionType;
import org.cointracker.transaction.writer.CsvFileWriterFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AllTransactionsWriterTask<T extends EthTransaction> implements Runnable {

    private final Logger logger;

    private final String walletAddress;
    private final TransactionType transactionType;
    private final TransactionsFetcher<T> transactionsFetcher;

    public AllTransactionsWriterTask(String walletAddress, TransactionType transactionType) {
        this.walletAddress = walletAddress;
        this.transactionType = transactionType;
        this.logger = Logger.getGlobal();

        CsvFileWriterFactory fileWriterFactory = new CsvFileWriterFactory(walletAddress);
        this.transactionsFetcher = new TransactionsFetcher<T>(walletAddress, transactionType,
                fileWriterFactory.create(transactionType)::writeToCSV);
    }

    @Override
    public void run() {
        try {
            logger.log(Level.INFO,
                    String.format("Fetching all transactions for walletAddress %s and TransactionType %s", walletAddress, transactionType));
            while(!transactionsFetcher.isDone()) {
                transactionsFetcher.fetchTransactions();
            }
            logger.log(Level.INFO,
                    String.format("Done writing all transactions for walletAddress %s and TransactionType %s", walletAddress, transactionType));

        } catch(Exception e) {
            logger.log(Level.SEVERE,
                    String.format("Error Writing Transactions for walletAddress %s and transactionType %s", walletAddress, transactionType),
                    e);
        }
    }

}
