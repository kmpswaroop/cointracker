package org.cointracker.transaction.writer;

import com.opencsv.CSVWriter;
import org.cointracker.transaction.model.EthTransaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractCsvFileWriter<T extends EthTransaction> implements CsvFileWriter<T> {

    private final Logger logger;
    private final String filePath;
    private final CSVWriter csvWriter;

    AbstractCsvFileWriter(final String filePath) throws IOException {
        this.logger = Logger.getGlobal();
        this.filePath = filePath;
        this.csvWriter = new CSVWriter(new FileWriter(filePath));
        csvWriter.writeNext(getHeaders());
        csvWriter.flush();
    }

    abstract String[] getHeaders();

    abstract String[] toRecord(T txnObj);

    @Override
    public void writeToCSV(List<T> txnObjList) {
        try {
            txnObjList.stream()
                    .map(this::toRecord)
                    .forEach(csvWriter::writeNext);
            csvWriter.flush();
            /*List<String[]> records = txnObjList.stream()
                    .map(this::toRecord)
                    .toList();
            csvWriter.writeAll(records);
            csvWriter.flush();*/
        } catch(Exception e) {
            String msg = "Error while writing transactions to file " + filePath;
            logger.log(Level.SEVERE, msg, e);
        }
    }
}
