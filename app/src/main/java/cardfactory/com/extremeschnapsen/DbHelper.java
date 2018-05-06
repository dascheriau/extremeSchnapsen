package cardfactory.com.extremeschnapsen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by NapeStar on 03.04.18.
 * helper class for creating SQLLite-Database
 * contains important constants like tablename, database version, name of columns
 * methods: constructor and onCreate(SQLiteDatabase db)
 */

public class DbHelper extends SQLiteOpenHelper {

   //für Singelton
    private static DbHelper sInstance;

    //LOG_TAG for filtering in logcat
    private static final String LOG_TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "extreme_schnapsen.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_PLAYER_LIST = "player_list";
    public static final String TABLE_CARD_LIST = "card_list";
    public static final String TABLE_DECK_LIST = "deck_list";
    public static final String TABLE_ROUNDPOINTS_LIST = "roundpoints_list";

    public static final String COLUMN_PLAYER_ID = "_id";
    public static final String COLUMN_PLAYER_USERNAME = "username";

    public static final String COLUMN_CARD_ID = "_id";
    public static final String COLUMN_CARDSUIT = "cardSuit";
    public static final String COLUMN_CARDRANK = "cardRank";
    public static final String COLUMN_CARDVALUE = "cardValue";

    public static final String COLUMN_DECK_ID = "_id";
    public static final String COLUMN_DECK_CARD_ID = "_cardID";
    public static final String COLUMN_DECKSUIT = "deckSuit";
    public static final String COLUMN_DECKRANK = "deckRank";
    public static final String COLUMN_DECKVALUE = "deckValue";
    public static final String COLUMN_DECKSTATUS = "deckStatus";
    public static final String COLUMN_DECKTRUMP = "decktrump";

    public static final String COLUMN_ROUNDPOINTS_ID = "id";
    public static final String COLUMN_CURRENTROUNDPOINTS = "current";
    public static final String COLUMN_POINTSPLAYER1 = "pointsplayer1";
    public static final String COLUMN_POINTSPLAYER2 = "pointsplayer2";

    //string for sql query -> CREATE TABLE
    public static final String SQL_CREATE_PLAYER_TABLE =
            "CREATE TABLE " + TABLE_PLAYER_LIST +
                    "(" + COLUMN_PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PLAYER_USERNAME + " TEXT NOT NULL);";

    public static final String SQL_CREATE_CARD_TABLE =
            "CREATE TABLE " + TABLE_CARD_LIST +
                    "(" + COLUMN_CARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CARDSUIT + " TEXT NOT NULL, " +
                    COLUMN_CARDRANK + " TEXT NOT NULL, " +
                    COLUMN_CARDVALUE + " INTEGER NOT NULL);";

    public static final String SQL_CREATE_DECK_TABLE =
            "CREATE TABLE " + TABLE_DECK_LIST +
                    "(" + COLUMN_DECK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DECK_CARD_ID + " INTEGER NOT NULL, " +
                    COLUMN_DECKSUIT + " TEXT NOT NULL, " +
                    COLUMN_DECKRANK + " TEXT NOT NULL, " +
                    COLUMN_DECKVALUE + " INTEGER NOT NULL, " +
                    COLUMN_DECKSTATUS + " INTEGER,  " +
                    COLUMN_DECKTRUMP + " INTEGER);";

    public static final String SQL_CREATE_ROUNDPOINTS_TABLE =
            "CREATE TABLE " + TABLE_ROUNDPOINTS_LIST +
                    "(" + COLUMN_ROUNDPOINTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CURRENTROUNDPOINTS + " INTEGER NOT NULL, " +
                    COLUMN_POINTSPLAYER1 + " INTEGER NOT NULL, " +
                    COLUMN_POINTSPLAYER2 + " INTEGER NOT NULL);";


    //für Singleton
    public static synchronized DbHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            Log.d(LOG_TAG, "DbHelper erzeugt eine Instanz von DbHelper.");
            sInstance = new DbHelper(context.getApplicationContext());
        }
        Log.d(LOG_TAG, "Eine Referenz auf die Instanz DbHelper wird übergeben.");
        return sInstance;
    }

    //constructor creates database
    private DbHelper(Context context) {
        //super(context, "PLATZHALTER_DATENBANKNAME", null, 1);
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }

    // onCreate method creates table player_list, if not already created
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE_PLAYER_TABLE + " angelegt.");
            db.execSQL(SQL_CREATE_PLAYER_TABLE);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE_CARD_TABLE + " angelegt.");
            db.execSQL(SQL_CREATE_CARD_TABLE);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE_DECK_TABLE + " angelegt.");
            db.execSQL(SQL_CREATE_DECK_TABLE);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE_ROUNDPOINTS_TABLE + " angelegt.");
            db.execSQL(SQL_CREATE_ROUNDPOINTS_TABLE);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}






