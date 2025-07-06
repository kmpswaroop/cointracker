package org.cointracker.transaction.writer;

public class WriteException extends Exception {

    public WriteException(String message) {
        super(message);
    }

    public WriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
