package com.example.rejsedagbogapp.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.R;

public class CreateTravelActivity extends AppCompatActivity {
    private Travel currentTravel;
    private TextView destET;
    private TextView fromET;
    private TextView toET;
    private TextView descET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_travel);

        destET = findViewById(R.id.travelDestinationName);
        fromET = findViewById(R.id.fromDate);
        toET = findViewById(R.id.toDate);
        descET = findViewById(R.id.textViewDescription);



    }

    public void saveTravel(View view) {
        String destination = destET.getText().toString();
        if (destination.length() == 0) {
            Toast.makeText(this, "Angiv en destination", Toast.LENGTH_LONG).show();
            return;
        }
        String from = fromET.getText().toString();
        String to = toET.getText().toString();
        String description = descET.getText().toString();
        Travel travel = currentTravel;
        if (travel != null) {
            travel.setDestination(destination);
            travel.setFromDate(from);
            travel.setEndDate(to);
            travel.setDescription(description);
        } else {
            travel = new Travel(destination, from, to, description);
        }
        setResult(RESULT_OK);
        finish();

    }
}
