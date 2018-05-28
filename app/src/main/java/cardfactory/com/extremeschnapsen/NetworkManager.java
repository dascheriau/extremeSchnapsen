package cardfactory.com.extremeschnapsen;

import android.content.Context;
import java.util.List;

public class NetworkManager  {

    private static NetworkManager networkManager; //create a static network manager

    private INetworkDisplay networkDisplay; //contains the network display interface object
    private Context context; //contains the GameActivity-Context

    private boolean isServer; //shows if the current phone is the server or the client

    private HTTPClient httpClient; //used for the http-client
    private HTTPServer httpServer; //used for the http-server

    private NetworkManager (Context context, INetworkDisplay networkDisplay) {
        this.networkDisplay = networkDisplay;
        this.context = context;
    }

    /**
     * implements a singleton, which returns a networkmanager-object
     * @param context contains the GameActivity-Context
     * @param networkDisplay contains the network display interface object
     * @return
     */
    public static NetworkManager getInstance(Context context, INetworkDisplay networkDisplay) {
        if (networkManager == null) {
            networkManager = new NetworkManager(context, networkDisplay);
        }
        return networkManager;
    }

    /**
     * starts the http-server and holds the current deck for the client
     * @param currentDeck the current, shuffled deck
     */
    public void startHttpServer(List<Deck> currentDeck) {
        isServer = true;

        httpServer = new HTTPServer(currentDeck, networkDisplay);
        httpServer.startServer();
    }

    /**
     * stop the http-server
     */
    public void stopHttpServer() {
        httpServer.stopHTTPServer();
    }

    /**
     * start the http-client
     */
    public void startHttpClient() {
        isServer = false;

        httpClient = new HTTPClient(context, networkDisplay);
        httpClient.getDeck(); //get the current deck from server
    }

    /**
     * send a card to the opposite phone
     * @param cardID contains the id of the played card
     */
    public void sendCard(int cardID) {

        if (isServer) {
            httpServer.setCardPlayed(cardID);
        }
        else
            httpClient.sendCard(cardID);

    }

    /**
     * called when the client has to wait for a played card from the server
     */
    public void waitForCard() {
        httpClient.getPlayedCard();
    }
}
