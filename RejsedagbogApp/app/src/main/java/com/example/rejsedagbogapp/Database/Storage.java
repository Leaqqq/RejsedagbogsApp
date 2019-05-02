package com.example.rejsedagbogapp.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Wrappers.TravelCursorWrapper;

public class Storage {
    private Storage() {
    }

    private static Storage storage;

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
            storage.initStorage();
        }
        return storage;
    }

    private TravelSQLHelper travelSQLHelper = TravelSQLHelper.getInstance();

    public Travel getTravel(long id) {
        SQLiteDatabase db = travelSQLHelper.getReadableDatabase();
        Cursor cursor = db.query("TRAVEL",
                new String[]{"_id", "DESTINATION", "FROMDATE", "TODATE", "DESCRIPTION"}, "_id=?", new String[]{"" + id}, null, null, null);
        Travel travel = new TravelCursorWrapper(cursor).getTravel();
        cursor.close();
        return travel;
    }

    public TravelCursorWrapper getTravels() {
        SQLiteDatabase db = travelSQLHelper.getReadableDatabase();
        Cursor cursor = db.query("TRAVEL",
                new String[]{"_id", "DESTINATION", "FROMDATE", "TODATE", "DESCRIPTION"}, null, null, null, null, null);
        return new TravelCursorWrapper(cursor);
    }

    public Long addTravel(Travel travel) {
        SQLiteDatabase db = travelSQLHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("DESTINATION", travel.getDestination());
        cv.put("FROMDATE", travel.getFromDate());
        cv.put("TODATE", travel.getEndDate());
        cv.put("DESCRIPTION", travel.getDescription());
        return db.insert("TRAVEL", null, cv);
    }
    public void updateTravel(Travel travel){
        SQLiteDatabase db=travelSQLHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("DESTINATION", travel.getDestination());
        cv.put("FROMDATE", travel.getFromDate());
        cv.put("TODATE", travel.getEndDate());
        cv.put("DESCRIPTION", travel.getDescription());
        db.update("TRAVEL",cv,"_id=?",new String[]{""+travel.getId()});
    }

    private void initStorage() {
        if (getTravels().getCount() == 0) {
            addTravel(new Travel("Denmark", "02/05/19", "04/05/19", "Going to Billund and visiting Legoland"));
            addTravel(new Travel("England", "01/10/2019", "10/10/2019", "Visiting family in Manchester"));
            addTravel(new Travel("Wakanda", "01/01/2020", "01/04/2019", "Top secret mission"));
            addTravel(new Travel("Mars", "21/07/2025", "Indefinite", "Visiting family at the Space-X base on Mars"));
        }
    }

}
