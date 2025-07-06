package org.cointracker.transaction.client.etherscan;

import org.cointracker.transaction.client.TransactionsRequest;
import org.cointracker.transaction.client.etherscan.api.Converter;
import org.cointracker.transaction.client.etherscan.api.TxnResponse;
import org.cointracker.transaction.model.EthNormalTransaction;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class NormalTransactionsClient extends EtherscanClient<EthNormalTransaction> {

    private static final String ACTION = "txlist";

    public NormalTransactionsClient(String apiKey) {
        super(apiKey);
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public List<EthNormalTransaction> getTransactions(String walletAddress, TransactionsRequest request) {
        try {
            String uri =  buildUri(walletAddress, request);
            List<TxnResponse> response = getTransactionsFromURI(uri);
            if (response != null) {
                return response
                        .stream()
                        .map(Converter::getEthNormalTransaction)
                        .collect(Collectors.toList());
            }
        } catch(Exception e) {
            String msg = "Error getting data from getNormalTxnUrl API";
            logger.log(Level.SEVERE, msg, e);
        }
        return null;
    }
}
