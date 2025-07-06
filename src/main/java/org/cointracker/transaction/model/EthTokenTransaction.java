package org.cointracker.transaction.model;

public class EthTokenTransaction extends EthTransaction {

    private String tokenName;
    private String tokenSymbol;

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }
}
