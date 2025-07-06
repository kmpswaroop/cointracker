package org.cointracker.transaction.writer;

import org.cointracker.transaction.model.EthNormalTransaction;

import java.io.IOException;

public class EthNormalTransactionCsvWriter extends AbstractCsvFileWriter<EthNormalTransaction> {

    private final String[] headers = {
            "Transaction Hash",
            "Timestamp",
            "From Address",
            "To Address",
            "Value",
            "Gas",
            "Gas Price",
            "Gas Used",
            "Transaction Type"
    };

    EthNormalTransactionCsvWriter(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    String[] getHeaders() {
        return headers;
    }

    @Override
    String[] toRecord(EthNormalTransaction ethNormalTransaction) {
        return new String[] {
                ethNormalTransaction.getHash(),
                ethNormalTransaction.getTimestamp(),
                ethNormalTransaction.getFromAddress(),
                ethNormalTransaction.getToAddress(),
                ethNormalTransaction.getValue(),
                ethNormalTransaction.getGas(),
                ethNormalTransaction.getGasPrice(),
                ethNormalTransaction.getGasUsed(),
                ethNormalTransaction.getTransactionType()
        };
    }
}
