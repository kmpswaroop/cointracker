package org.cointracker.transaction.model;

public class EthERC1155Transaction extends EthTokenTransaction {

    public EthERC1155Transaction() {
        this.transactionType = TransactionType.ERC1155Token.name();
    }
}
