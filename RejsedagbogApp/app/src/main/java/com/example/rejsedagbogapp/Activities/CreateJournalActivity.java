package com.example.rejsedagbogapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.R;

public class CreateJournalActivity extends AppCompatActivity {

    private Journal currentJournal;
    private TextView titleET;
    private TextView textET;
    private TextView timeET;
    private TextView longtitudeET;
    private TextView latitudeET;
    private TextView weblinksET;
    private Long id=null;
    private Travel travel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_journal);
        id=(Long)getIntent().getSerializableExtra("travelID");
        travel= Storage.getInstance().getTravel(id);

        titleET = findViewById(R.id.titelNote);
        textET = findViewById(R.id.textNote);
        timeET = findViewById(R.id.timeNote);
        longtitudeET = findViewById(R.id.longitudeNote);
        latitudeET=findViewById(R.id.LatitudeNote);

        weblinksET = findViewById(R.id.WeblinksNote);
    }

    public void saveJournal(View view) {
        String title = titleET.getText().toString();
        if (title.length() == 0) {
            Toast.makeText(this, "Angiv en titel", Toast.LENGTH_LONG).show();
            return;
        }
        String text = textET.getText().toString();
        String time = timeET.getText().toString();
        String longtitude = longtitudeET.getText().toString();
        String latitude=latitudeET.getText().toString();
        String weblinks = weblinksET.getText().toString();
        Journal journal = currentJournal;
        if (journal != null) {
            journal.setTitle(title);
            journal.setText(text);
            journal.setTime(time);
            journal.setLongitude(longtitude);
            journal.setLatitude(latitude);
            journal.setWebLinks(weblinks);
            journal.setTravel(travel);
        } else {
            journal = new Journal(title, text, time, longtitude,latitude,weblinks);
            journal.setTravel(travel);
        }
        if(updateJournal(journal) !=null){
            setResult(RESULT_OK);
            finish();
        }
    }

    public Journal updateJournal(Journal journal){
        if(journal.getId()==null){
            journal.setId(Storage.getInstance().addJournal(journal));
        }
        return journal;
    }
}
