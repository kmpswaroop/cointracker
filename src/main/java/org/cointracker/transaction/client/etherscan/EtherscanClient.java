package org.cointracker.transaction.client.etherscan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.cointracker.transaction.client.EthClient;
import org.cointracker.transaction.client.TransactionsRequest;
import org.cointracker.transaction.client.etherscan.api.EtherscanAPIResponse;
import org.cointracker.transaction.client.etherscan.api.TxnResponse;
import org.cointracker.transaction.model.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class EtherscanClient<T extends EthTransaction> implements EthClient {

    protected final String BASE_URL = "https://api.etherscan.io/v2/api";
    protected final String API_KEY;

    protected final Logger logger;
    private final HttpClient client;
    private final Gson jsonParser;

    public EtherscanClient(final String apiKey) {
        this.API_KEY = apiKey;
        this.logger = Logger.getGlobal();
        this.jsonParser = new GsonBuilder().create();
        this.client = HttpClient.newBuilder().build();
    }

    public abstract List<T> getTransactions(String walletAddress, TransactionsRequest request);

    public abstract String getAction();

    protected String buildUri(String walletAddress, TransactionsRequest request) {
        return BASE_URL +
                "?chainid=1" +
                "&module=account" +
                "&action=" + getAction() +
                "&address=" + walletAddress +
                "&startblock=" + request.getStartBlock() +
                "&endblock=" + request.getEndBlock() +
                "&offset=" + request.getOffset() +
                "&page=1" +
                "&sort=asc" +
                "&apikey=" + API_KEY;
    }

    /**
     * Get data from Etherscan API
     * todo: Enhance method to incorporate non-HTTP200 status codes
     * @param uri Get Request URI
     * @return List of Transactions or null
     * @throws APIException In case of errors
     */
    protected List<TxnResponse> getTransactionsFromURI(String uri) throws APIException {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                    .GET()
                    .build();
            HttpResponse<String> jsonResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            EtherscanAPIResponse<List<TxnResponse>> response = jsonParser.fromJson(jsonResponse.body(),
                    new TypeToken<EtherscanAPIResponse<List<TxnResponse>>>(){}.getType());

            if (response != null) {
                return response.getResult();
            }
        } catch(Exception e) {
            throw new APIException("Error getting data from API", e);
        }
        return null;
    }

}