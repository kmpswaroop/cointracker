package org.cointracker.transaction.model;

public class EthNormalTransaction extends EthTransaction {

    public EthNormalTransaction() {
        this.transactionType = TransactionType.External.name();
    }
}
