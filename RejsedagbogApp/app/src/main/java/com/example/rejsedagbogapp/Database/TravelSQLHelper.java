package com.example.rejsedagbogapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TravelSQLHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "travel"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database
    private static Context applicationContext;
    private static TravelSQLHelper travelSQLHelper;

    public static void setApplicationContext(Context context) {
        applicationContext = context.getApplicationContext();
    }
    private TravelSQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static TravelSQLHelper getInstance() {
        if (travelSQLHelper == null) {
            travelSQLHelper = new TravelSQLHelper(applicationContext);
        }
        return travelSQLHelper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE TRAVEL (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "DESTINATION TEXT," +
                    "FROMDATE TEXT, " +
                    "TODATE TEXT ," +
                    "DESCRIPTION TEXT)");

            db.execSQL("CREATE TABLE JOURNAL(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "TITLE TEXT," +
                    "TEXT TEXT, " +
                    "TIME TEXT ," +
                    "DESCRIPTION TEXT,"+
                    "FOREIGN KEY (TRAVELId) REFERENCES TRAVEL(_id) ON DELETE CASCADE)");
        }else if ( oldVersion < 2) {
            db.execSQL("ALTER TABLE TRAVEL ADD COLUMN DESCRIPTION");
        }
    }

}
