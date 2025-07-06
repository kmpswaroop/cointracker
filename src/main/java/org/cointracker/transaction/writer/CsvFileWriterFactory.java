package org.cointracker.transaction.writer;

import org.cointracker.transaction.model.TransactionType;

import java.io.File;
import java.io.IOException;

public class CsvFileWriterFactory {

    private final String filePath;

    public CsvFileWriterFactory(final String walletAddress) {
        this.filePath = System.getProperty("csv.writer.basedir") + walletAddress;
        new File(filePath).mkdirs();
    }

    public CsvFileWriter create(final TransactionType transactionType) {
        try {
            return switch (transactionType) {
                case External -> new EthNormalTransactionCsvWriter(filePath + "/NormalTransactions.csv");
                case Internal -> new EthInternalTransactionCsvWriter(filePath + "/InternalTransactions.csv");
                case ERC20Token -> new EthTokenTransactionCsvWriter(filePath + "/ERC20Transactions.csv");
                case ERC721Token -> new EthTokenTransactionCsvWriter(filePath + "/ERC721Transactions.csv");
                case ERC1155Token -> new EthTokenTransactionCsvWriter(filePath + "/ERC1155Transactions.csv");
            };
        } catch(IOException e) {

        }
        return null;
    }

}
