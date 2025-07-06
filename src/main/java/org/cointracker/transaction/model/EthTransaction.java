package org.cointracker.transaction.model;

public class EthTransaction {

    private String hash;
    private String blockNumber;
    private String timestamp;
    private String fromAddress;
    private String toAddress;
    private String value;
    private String gas;
    private String gasPrice;
    private String gasUsed;
    protected String transactionType;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "EthTransaction{" +
                "hash='" + hash + '\'' +
                ", blockNumber='" + blockNumber + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", value='" + value + '\'' +
                ", gas='" + gas + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                ", gasUsed='" + gasUsed + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }

}
