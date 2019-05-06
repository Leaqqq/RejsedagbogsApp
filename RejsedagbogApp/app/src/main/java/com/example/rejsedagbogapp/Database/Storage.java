package com.example.rejsedagbogapp.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Wrappers.JournalCursorWrapper;
import com.example.rejsedagbogapp.Wrappers.TravelCursorWrapper;

import java.util.ArrayList;

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

        Travel travel = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                Long iD = cursor.getLong(cursor.getColumnIndex("_id"));
                String destination = cursor.getString(cursor.getColumnIndex("DESTINATION"));
                String fromDate = cursor.getString(cursor.getColumnIndex("FROMDATE"));
                String toDate = cursor.getString(cursor.getColumnIndex("TODATE"));
                String description = cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
                travel = new Travel(iD, destination, fromDate, toDate, description);

            }
            cursor.close();
        }

        return travel;

    }
    public Journal getJournal(long id) {
        SQLiteDatabase db = travelSQLHelper.getReadableDatabase();
        Cursor cursor = db.query("JOURNAL",
                new String[]{"_id", "TITLE", "TEXT", "TIME", "LONGITUDE", "LATITUDE", "WEBLINKS","TRAVELId"}, "_id=?", new String[]{"" + id}, null, null, null);
        Journal journal=null;
        if(cursor.moveToFirst()){
            Long iD=cursor.getLong(cursor.getColumnIndex("_id"));
            String title=cursor.getString(cursor.getColumnIndex("TITLE"));
            String text=cursor.getString(cursor.getColumnIndex("TEXT"));
            String time=cursor.getString(cursor.getColumnIndex("TIME"));
            String longitude=cursor.getString(cursor.getColumnIndex("LONGITUDE"));
            String latitude=cursor.getString(cursor.getColumnIndex("LATITUDE"));
            String weblinks=cursor.getString(cursor.getColumnIndex("WEBLINKS"));
            Long travelid=cursor.getLong(cursor.getColumnIndex("TRAVELId"));
            journal=new Journal(iD,title,text,time,longitude,latitude,weblinks);
        }
        cursor.close();
        return journal;
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

    public void updateTravel(Travel travel) {
        SQLiteDatabase db = travelSQLHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("DESTINATION", travel.getDestination());
        cv.put("FROMDATE", travel.getFromDate());
        cv.put("TODATE", travel.getEndDate());
        cv.put("DESCRIPTION", travel.getDescription());
        db.update("TRAVEL", cv, "_id=?", new String[]{"" + travel.getId()});
    }

    public boolean deleteTravel(Long id) {
        SQLiteDatabase db = travelSQLHelper.getWritableDatabase();
        return db.delete("TRAVEL", "_id = ?", new String[]{"" + id}) > 0;
    }


    public JournalCursorWrapper getJournalsFromTravel(Travel travel) {
        SQLiteDatabase db = travelSQLHelper.getReadableDatabase();
        Cursor cursor = db.query("JOURNAL",
                new String[]{"_id", "TITLE", "TEXT", "TIME", "LONGITUDE", "LATITUDE", "WEBLINKS","TRAVELId"}, "TRAVELId = ?", new String[]{"" + travel.getId()}, null, null, null);
        return new JournalCursorWrapper(cursor);
    }

    public Long addJournal(Journal journal) {
        SQLiteDatabase db = travelSQLHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TITLE", journal.getTitle());
        cv.put("TEXT", journal.getText());
        cv.put("TIME", journal.getTime());
        cv.put("LONGITUDE", journal.getLongitude());
        cv.put("LATITUDE", journal.getLatitude());
        cv.put("WEBLINKS", journal.getWebLinks());
        cv.put("TRAVELId",journal.getTravel().getId());
        return db.insert("JOURNAL", null, cv);
    }


    private void initStorage() {
        if (getTravels().getCount() == 0) {
            Travel travel1=new Travel("Denmark", "02/05/19", "04/05/19", "Going to Billund and visiting Legoland");
            Travel travel2=new Travel("England", "01/10/2019", "10/10/2019", "Visiting family in Manchester");
            Travel travel3=new Travel("Portugal", "01/10/2019", "10/10/2019", "Visiting family in Portugal");

            Journal journal1=new Journal("Dagbog dag 1","hej dagbog her er tekst","klokken 10","56.2639","9.5018","et weblink");
            Journal journal2=new Journal("Dagbog dag 2","hej dagbog her er tekst igen, det er mig","klokken 18","51.5074","0.1278","https://en.wikipedia.org/wiki/Great_Britain");
            Journal journal3=new Journal("Journal3","hej dagbog her er tekst igen, det er mig, jeg har haft en god dag i dag ved stranden.","klokken 18","-34","151","www.google.com");



            travel1.addJournal(journal1);
            travel2.addJournal(journal2);
            travel2.addJournal(journal3);

           travel1.setId(addTravel(travel1));
           travel2.setId(addTravel(travel2));
           travel3.setId(addTravel(travel3));

            addJournal(journal1);
            addJournal(journal2);
            addJournal(journal3);

            Log.d("SE HER","travel2 id: "+travel2.getId());
            Log.d("SE HER2","travel2 id fra journal2:"+journal2.getTravel().getId());

        }
    }
}
