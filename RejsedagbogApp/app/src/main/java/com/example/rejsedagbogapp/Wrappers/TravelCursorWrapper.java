package com.example.rejsedagbogapp.Wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.rejsedagbogapp.Adapters.TravelCursorAdapter;
import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Database.Storage;

import java.util.ArrayList;

public class TravelCursorWrapper extends CursorWrapper {
    public TravelCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Travel getTravel() {

        Long id = getLong(getColumnIndex("_id"));
        String destination = getString(getColumnIndex("DESTINATION"));
        String fromDate = getString(getColumnIndex("FROMDATE"));
        String toDate = getString(getColumnIndex("TODATE"));
        String description = getString(getColumnIndex("DESCRIPTION"));

        // return  new Travel(id, destination, fromDate, toDate, description);
        Travel travel = new Travel(id, destination, fromDate, toDate, description);


        JournalCursorWrapper jw = Storage.getInstance().getJournalsFromTravel(travel);
        ArrayList<Journal> journals = new ArrayList<>();

        for(jw.moveToFirst(); !jw.isAfterLast(); jw.moveToNext()){
        journals.add(jw.getJournal());
        }

        travel.setJournalsForTravel(journals);


        return travel;
    }
}
