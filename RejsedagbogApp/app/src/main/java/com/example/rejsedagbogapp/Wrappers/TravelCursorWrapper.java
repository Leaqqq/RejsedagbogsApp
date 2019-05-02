package com.example.rejsedagbogapp.Wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.rejsedagbogapp.Adapters.TravelCursorAdapter;
import com.example.rejsedagbogapp.Classes.Travel;

public class TravelCursorWrapper extends CursorWrapper {
    public TravelCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Travel getTravel(){


    Long id=getLong(getColumnIndex("_id"));
    String destination=getString(getColumnIndex("DESTINATION"));
    String fromDate=getString(getColumnIndex("FROMDATE"));
    String toDate=getString(getColumnIndex("TODATE"));
    String description=getString(getColumnIndex("DESCRIPTION"));
    return new Travel(id,destination,fromDate,toDate,description);

    }
}
