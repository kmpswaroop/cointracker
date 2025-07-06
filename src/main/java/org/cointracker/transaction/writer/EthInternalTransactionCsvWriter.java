package org.cointracker.transaction.writer;

import org.cointracker.transaction.model.EthInternalTransaction;

import java.io.IOException;

public class EthInternalTransactionCsvWriter extends AbstractCsvFileWriter<EthInternalTransaction> {

    private final String[] headers = {
            "Transaction Hash",
            "Timestamp",
            "From Address",
            "To Address",
            "Contract Address",
            "Value",
            "Gas",
            "Gas Price",
            "Gas Used",
            "Transaction Type"
    };

    EthInternalTransactionCsvWriter(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    String[] getHeaders() {
        return headers;
    }

    @Override
    String[] toRecord(EthInternalTransaction ethInternalTransaction) {
        return new String[] {
                ethInternalTransaction.getHash(),
                ethInternalTransaction.getTimestamp(),
                ethInternalTransaction.getFromAddress(),
                ethInternalTransaction.getToAddress(),
                ethInternalTransaction.getContractAddress(),
                ethInternalTransaction.getValue(),
                ethInternalTransaction.getGas(),
                ethInternalTransaction.getGasPrice(),
                ethInternalTransaction.getGasUsed(),
                ethInternalTransaction.getTransactionType()
        };
    }
}
