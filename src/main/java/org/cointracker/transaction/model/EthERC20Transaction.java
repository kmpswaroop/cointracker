package org.cointracker.transaction.model;

public class EthERC20Transaction extends EthTokenTransaction {

    public EthERC20Transaction() {
        this.transactionType = TransactionType.ERC20Token.name();
    }
}
