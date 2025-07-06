package org.cointracker.transaction.writer;

import org.cointracker.transaction.model.EthTokenTransaction;

import java.io.IOException;

public class EthTokenTransactionCsvWriter extends AbstractCsvFileWriter<EthTokenTransaction> {

    private final String[] headers = {
            "Transaction Hash",
            "Timestamp",
            "From Address",
            "To Address",
            "Value",
            "Token Name",
            "Token Symbol",
            "Gas",
            "Gas Price",
            "Gas Used",
            "Transaction Type"
    };

    EthTokenTransactionCsvWriter(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    String[] getHeaders() {
        return headers;
    }

    @Override
    String[] toRecord(EthTokenTransaction ethTokenTransaction) {
        return new String[] {
                ethTokenTransaction.getHash(),
                ethTokenTransaction.getTimestamp(),
                ethTokenTransaction.getFromAddress(),
                ethTokenTransaction.getToAddress(),
                ethTokenTransaction.getValue(),
                ethTokenTransaction.getTokenName(),
                ethTokenTransaction.getTokenSymbol(),
                ethTokenTransaction.getGas(),
                ethTokenTransaction.getGasPrice(),
                ethTokenTransaction.getGasUsed(),
                ethTokenTransaction.getTransactionType()
        };
    }
}
