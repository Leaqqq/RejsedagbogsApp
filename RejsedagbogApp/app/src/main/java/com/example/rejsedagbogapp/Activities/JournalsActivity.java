package com.example.rejsedagbogapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rejsedagbogapp.Adapters.JournalCursorAdapter;
import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.Database.TravelSQLHelper;
import com.example.rejsedagbogapp.R;

public class JournalsActivity extends Activity {
    private final int REQUEST_CREATE_JOURNAL = 1;
    private JournalCursorAdapter journalAdapter;
    Travel travel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journals);
        TravelSQLHelper.setApplicationContext(this);

        long id = (Long) getIntent().getSerializableExtra("travelID");
        travel = Storage.getInstance().getTravel(id);

        journalAdapter = new JournalCursorAdapter(this, R.layout.journal_item, Storage.getInstance().getJournalsFromTravel(travel),
                new String[]{"TITLE"},
                new int[]{R.id.journalname}, 0);

        ListView journalsLw=findViewById(R.id.journalslw);
        journalsLw.setAdapter(journalAdapter);
        Log.d("KIG HER","TEST"+travel.getJournalsForTravel().toString());



    }

    public void createJournalClick(View view) {
        Intent intent = new Intent(this, CreateJournalActivity.class);
        startActivityForResult(intent, REQUEST_CREATE_JOURNAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CREATE_JOURNAL:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, "Journal entry succesfully added", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
