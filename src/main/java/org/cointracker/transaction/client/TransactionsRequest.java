package org.cointracker.transaction.client;

public class TransactionsRequest {

    private int offset = 1000;
    private String startBlock = "0";
    private String endBlock = "latest";

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getStartBlock() {
        return startBlock;
    }

    public void setStartBlock(String startBlock) {
        this.startBlock = startBlock;
    }

    public void setStartBlock(Integer startBlock) {
        this.startBlock = String.valueOf(startBlock);
    }

    public String getEndBlock() {
        return endBlock;
    }

    public void setEndBlock(String endBlock) {
        this.endBlock = endBlock;
    }

    public void setEndBlock(Integer endBlock) {
        this.endBlock = String.valueOf(endBlock);
    }

    @Override
    public String toString() {
        return "TransactionsRequest{" +
                "offset=" + offset +
                ", startBlock='" + startBlock + '\'' +
                ", endBlock='" + endBlock + '\'' +
                '}';
    }
}
