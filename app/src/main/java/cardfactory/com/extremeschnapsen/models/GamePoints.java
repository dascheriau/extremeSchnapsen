package cardfactory.com.extremeschnapsen.models;

import java.io.Serializable;

/**
 * Created by NapeStar on 08.05.18.
 */

public class GamePoints implements Serializable {
    private long gamePointsID;
    private int gameID;
    private int gamePointsPlayer1;
    private int gamePoinstsPlayer2;

    public GamePoints(long gamePointsID, int gameID, int gamePointsPlayer1, int gamePoinstsPlayer2) {
        this.gamePointsID = gamePointsID;
        this.gameID = gameID;
        this.gamePointsPlayer1 = gamePointsPlayer1;
        this.gamePoinstsPlayer2 = gamePoinstsPlayer2;
    }

    public long getGamePointsID() {
        return gamePointsID;
    }

    public void setGamePointsID(long gamePointsID) {
        this.gamePointsID = gamePointsID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getGamePointsPlayer1() {
        return gamePointsPlayer1;
    }

    public void setGamePointsPlayer1(int gamePointsPlayer1) {
        this.gamePointsPlayer1 = gamePointsPlayer1;
    }

    public int getGamePointsPlayer2() {
        return gamePoinstsPlayer2;
    }

    public void setGamePoinstsPlayer2(int gamePoinstsPlayer2) {
        this.gamePoinstsPlayer2 = gamePoinstsPlayer2;
    }

    @Override
    public String toString(){
        return gamePointsID + " " + gameID + " " + gamePointsPlayer1 + " " + gamePoinstsPlayer2;
    }
}
