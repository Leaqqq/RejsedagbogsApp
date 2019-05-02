package com.example.rejsedagbogapp.Wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.Classes.Travel;

public class JournalCursorWrapper extends CursorWrapper {
    public JournalCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Journal getJournal(){

    Long id=getLong(getColumnIndex("_id"));
    String title=getString(getColumnIndex("TITLE"));
    String text=getString(getColumnIndex("TEXT"));
    String time=getString(getColumnIndex("TIME"));
    String gps=getString(getColumnIndex("LONGITUDE"));
    String weblinks=getString(getColumnIndex("WEBLINKS"));
    return new Journal(id,title,text,time,gps,"",weblinks);

    }
}
