package com.example.rejsedagbogapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.R;


public class TravelActivity extends AppCompatActivity {

    Travel travel=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        long id=(Long)getIntent().getSerializableExtra("travel");
        travel=Storage.getInstance().getTravel(id);

        TextView destTW=findViewById(R.id.existingDestinationName);
        destTW.setText(travel.getDestination());

        TextView fromTW=findViewById(R.id.existingFromDate);
        fromTW.setText(travel.getFromDate());

        TextView toDateTW=findViewById(R.id.existingToDate);
        toDateTW.setText(travel.getEndDate());

        TextView descTW=findViewById(R.id.existingDescription);
        descTW.setText(travel.getDescription());
    }

    public void viewJournalsButton(View view){
        Intent intent= new Intent(this,JournalsActivity.class);
        intent.putExtra("travelID",travel.getId());
        TravelActivity.this.startActivity(intent);

    }
}
