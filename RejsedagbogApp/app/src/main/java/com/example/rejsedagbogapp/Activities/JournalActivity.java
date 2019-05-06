package com.example.rejsedagbogapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rejsedagbogapp.Classes.Journal;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.R;

import org.w3c.dom.Text;

public class JournalActivity extends AppCompatActivity {
    Long id=null;
    Journal journal=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        id=(Long)getIntent().getSerializableExtra("journal");
        journal= Storage.getInstance().getJournal(id);

        TextView titleTW=findViewById(R.id.titelNote);
        titleTW.setText(journal.getTitle());

        TextView textTW=findViewById(R.id.textNote);
        textTW.setText(journal.getText());

        TextView timeTW=findViewById(R.id.timeNote);
        timeTW.setText(journal.getTime());

        TextView gpsTW=findViewById(R.id.GPSNote);
        gpsTW.setText("Latitude: "+journal.getLatitude()+"   "+"Longtitude:  "+journal.getLongitude());

        TextView weblinksTW=findViewById(R.id.WeblinksNote);
        weblinksTW.setText(journal.getWebLinks());

    }
    public void viewOnMapButton(View view){
        Intent intent= new Intent(this,MapsActivity.class);
        intent.putExtra("journalID",id);
        JournalActivity.this.startActivity(intent);

    }
}
