package org.cointracker.transaction.client;

import org.cointracker.transaction.client.etherscan.*;
import org.cointracker.transaction.model.TransactionType;

public class EthClientFactory {

    private final String apiKey;

    public EthClientFactory() {
        this.apiKey = System.getProperty("etherscan.apikey");
    }

    public EthClient create(final TransactionType transactionType) {
        return switch (transactionType) {
            case External -> new NormalTransactionsClient(apiKey);
            case Internal -> new InternalTransactionsClient(apiKey);
            case ERC20Token -> new ERC20TransactionsClient(apiKey);
            case ERC721Token -> new ERC721TransactionsClient(apiKey);
            case ERC1155Token -> new ERC1155TransactionsClient(apiKey);
        };
    }

}
