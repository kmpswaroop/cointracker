package org.cointracker.transaction.model;

public class EthInternalTransaction extends EthTransaction {

    private String contractAddress;

    public EthInternalTransaction() {
        this.transactionType = TransactionType.Internal.name();
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }
}
