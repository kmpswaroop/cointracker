package org.cointracker.transaction;

import org.cointracker.transaction.script.Runner;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Set Property "etherscan.apikey" to set key for etherscan apis
     * Set Property "csv.writer.basedir" to set base directory for writing files
     * @param args
     */
    public static void main(String[] args) {
        List<String> walletAddressList = new ArrayList<>();
        walletAddressList.add("0xa39b189482f984388a34460636fea9eb181ad1a6");
        walletAddressList.add("0xd620AADaBaA20d2af700853C4504028cba7C3333");
        walletAddressList.add("0xfb50526f49894b78541b776f5aaefe43e3bd8590");
        walletAddressList.add("0xc5102fE9359FD9a28f877a67E36B0F050d81a3CC");

        Runner runner = new Runner(walletAddressList);
        runner.start();
    }
}