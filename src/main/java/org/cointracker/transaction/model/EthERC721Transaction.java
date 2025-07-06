package org.cointracker.transaction.model;

public class EthERC721Transaction extends EthTokenTransaction {

    public EthERC721Transaction() {
        this.transactionType = TransactionType.ERC721Token.name();
    }
}
