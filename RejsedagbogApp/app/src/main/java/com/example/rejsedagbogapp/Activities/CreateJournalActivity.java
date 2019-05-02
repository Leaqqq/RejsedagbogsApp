package com.example.rejsedagbogapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.R;

public class CreateJournalActivity extends AppCompatActivity {

    private Journal currentJournal;
    private TextView titleET;
    private TextView textET;
    private TextView timeET;
    private TextView gpsET;
    private TextView weblinksET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_journal);

        titleET = findViewById(R.id.titelNote);
        textET = findViewById(R.id.textNote);
        timeET = findViewById(R.id.timeNote);
        gpsET = findViewById(R.id.GPSNote);
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
        String gps = gpsET.getText().toString();
        String weblinks = weblinksET.getText().toString();
        Journal journal = currentJournal;
        if (journal != null) {
            journal.setTitle(title);
            journal.setText(text);
            journal.setTime(time);
            journal.setLatitude(gps); //Mangler at få sat longitude, eller ændret måden det bliver sat op på.
            journal.setWebLinks(weblinks);
        } else {
            journal = new Journal(title, text, time, gps,"0",weblinks);
        }
        setResult(RESULT_OK);
        finish();
    }
}
