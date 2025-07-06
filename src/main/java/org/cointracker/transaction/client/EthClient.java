package org.cointracker.transaction.client;

import org.cointracker.transaction.model.EthTransaction;

import java.util.List;

public interface EthClient<T extends EthTransaction> {

    /**
     * Get Transactions for the given wallet address from an external API.
     * The invoker gets a null response in case the data from the API is unavailable.
     * @param walletAddress String wallet address
     * @param request Request params
     * @return List of Transactions or null in case of API unavailability
     */
    List<T> getTransactions(String walletAddress, TransactionsRequest request);

}
