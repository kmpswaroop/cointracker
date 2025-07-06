package org.cointracker.transaction.client.etherscan;

public class APIException extends Exception {

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }
}
