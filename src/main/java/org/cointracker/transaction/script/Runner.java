package org.cointracker.transaction.script;

import org.cointracker.transaction.model.*;
import org.cointracker.transaction.writer.CsvFileWriterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private final List<AllTransactionsWriterTask> tasks = new ArrayList<>();
    private final ExecutorService executorService;

    public Runner(final List<String> walletAddressList) {
        this.executorService = Executors.newFixedThreadPool(5);
        walletAddressList.forEach(this::createTasks);
    }

    public void start() {
        this.tasks.forEach(executorService::submit);
        executorService.shutdown();
    }

    private void createTasks(final String walletAddress) {
        tasks.add(new AllTransactionsWriterTask<EthNormalTransaction>(
                walletAddress,
                TransactionType.External)
        );
        tasks.add(new AllTransactionsWriterTask<EthInternalTransaction>(
                walletAddress,
                TransactionType.Internal)
        );
        tasks.add(new AllTransactionsWriterTask<EthERC20Transaction>(
                walletAddress,
                TransactionType.ERC20Token)
        );
        tasks.add(new AllTransactionsWriterTask<EthERC721Transaction>(
                walletAddress,
                TransactionType.ERC721Token)
        );
        tasks.add(new AllTransactionsWriterTask<EthERC1155Transaction>(
                walletAddress,
                TransactionType.ERC1155Token)
        );
    }

}
