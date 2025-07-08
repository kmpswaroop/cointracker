package org.cointracker.transaction.client.etherscan.api;

import org.cointracker.transaction.model.*;

/**
 * A helper class to convert the API TxnResponse Object to the Model Object
 * todo: This class needs to be refactored, as it is very tedious and not a clean way to map objects.
 */
public class Converter {

    public static EthNormalTransaction getEthNormalTransaction(TxnResponse txnResponse) {
        EthNormalTransaction ethNormalTransaction = new EthNormalTransaction();
        ethNormalTransaction.setHash(txnResponse.getHash());
        ethNormalTransaction.setBlockNumber(txnResponse.getBlockNumber());
        ethNormalTransaction.setTimestamp(txnResponse.getTimeStamp());
        ethNormalTransaction.setFromAddress(txnResponse.getFrom());
        ethNormalTransaction.setToAddress(txnResponse.getTo());
        ethNormalTransaction.setValue(txnResponse.getValue());
        ethNormalTransaction.setGas(txnResponse.getGas());
        return ethNormalTransaction;
    }

    public static EthInternalTransaction getEthInternalTransaction(TxnResponse txnResponse) {
        EthInternalTransaction ethInternalTransaction = new EthInternalTransaction();
        ethInternalTransaction.setHash(txnResponse.getHash());
        ethInternalTransaction.setBlockNumber(txnResponse.getBlockNumber());
        ethInternalTransaction.setTimestamp(txnResponse.getTimeStamp());
        ethInternalTransaction.setFromAddress(txnResponse.getFrom());
        ethInternalTransaction.setToAddress(txnResponse.getTo());
        ethInternalTransaction.setValue(txnResponse.getValue());
        ethInternalTransaction.setGas(txnResponse.getGas());
        ethInternalTransaction.setContractAddress(txnResponse.getContractAddress());
        return ethInternalTransaction;
    }

    public static EthERC20Transaction getEthERC20Transaction(TxnResponse txnResponse) {
        EthERC20Transaction ethERC20Transaction = new EthERC20Transaction();
        ethERC20Transaction.setHash(txnResponse.getHash());
        ethERC20Transaction.setBlockNumber(txnResponse.getBlockNumber());
        ethERC20Transaction.setTimestamp(txnResponse.getTimeStamp());
        ethERC20Transaction.setFromAddress(txnResponse.getFrom());
        ethERC20Transaction.setToAddress(txnResponse.getTo());
        ethERC20Transaction.setValue(txnResponse.getValue());
        ethERC20Transaction.setGas(txnResponse.getGas());
        ethERC20Transaction.setTokenName(txnResponse.getTokenName());
        ethERC20Transaction.setTokenSymbol(txnResponse.getTokenSymbol());
        return ethERC20Transaction;
    }

    public static EthERC721Transaction getEthERC721Transaction(TxnResponse txnResponse) {
        EthERC721Transaction ethERC721Transaction = new EthERC721Transaction();
        ethERC721Transaction.setHash(txnResponse.getHash());
        ethERC721Transaction.setBlockNumber(txnResponse.getBlockNumber());
        ethERC721Transaction.setTimestamp(txnResponse.getTimeStamp());
        ethERC721Transaction.setFromAddress(txnResponse.getFrom());
        ethERC721Transaction.setToAddress(txnResponse.getTo());
        ethERC721Transaction.setValue(txnResponse.getValue());
        ethERC721Transaction.setGas(txnResponse.getGas());
        ethERC721Transaction.setTokenName(txnResponse.getTokenName());
        ethERC721Transaction.setTokenSymbol(txnResponse.getTokenSymbol());
        return ethERC721Transaction;
    }

    public static EthERC1155Transaction getEthERC1155Transaction(TxnResponse txnResponse) {
        EthERC1155Transaction ethERC1155Transaction = new EthERC1155Transaction();
        ethERC1155Transaction.setHash(txnResponse.getHash());
        ethERC1155Transaction.setBlockNumber(txnResponse.getBlockNumber());
        ethERC1155Transaction.setTimestamp(txnResponse.getTimeStamp());
        ethERC1155Transaction.setFromAddress(txnResponse.getFrom());
        ethERC1155Transaction.setToAddress(txnResponse.getTo());
        ethERC1155Transaction.setValue(txnResponse.getValue());
        ethERC1155Transaction.setGas(txnResponse.getGas());
        ethERC1155Transaction.setTokenName(txnResponse.getTokenName());
        ethERC1155Transaction.setTokenSymbol(txnResponse.getTokenSymbol());
        return ethERC1155Transaction;
    }

}
