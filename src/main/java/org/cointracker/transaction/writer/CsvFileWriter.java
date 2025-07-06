package org.cointracker.transaction.writer;

import org.cointracker.transaction.model.EthTransaction;

import java.util.List;

public interface CsvFileWriter<T extends EthTransaction> {

    void writeToCSV(List<T> transactions);

}
