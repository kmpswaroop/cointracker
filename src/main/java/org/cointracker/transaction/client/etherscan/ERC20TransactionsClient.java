package org.cointracker.transaction.client.etherscan;

import org.cointracker.transaction.client.TransactionsRequest;
import org.cointracker.transaction.client.etherscan.api.Converter;
import org.cointracker.transaction.client.etherscan.api.TxnResponse;
import org.cointracker.transaction.model.EthTokenTransaction;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class ERC20TransactionsClient extends EtherscanClient<EthTokenTransaction>{

    private static final String ACTION = "tokentx";

    public ERC20TransactionsClient(String apiKey) {
        super(apiKey);
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public List<EthTokenTransaction> getTransactions(String walletAddress, TransactionsRequest request) {
        try {
            String uri = buildUri(walletAddress, request);
            List<TxnResponse> response = getTransactionsFromURI(uri);
            if (response != null) {
                return response
                        .stream()
                        .map(Converter::getEthERC20Transaction)
                        .collect(Collectors.toList());
            }
        } catch(Exception e) {
            String errMsg = "Error getting data from getERC20TxnUrl API";
            logger.log(Level.SEVERE, errMsg, e);
        }
        return null;
    }
}
