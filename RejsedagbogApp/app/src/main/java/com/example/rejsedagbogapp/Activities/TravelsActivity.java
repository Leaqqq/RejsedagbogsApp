package com.example.rejsedagbogapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.rejsedagbogapp.Adapters.TravelCursorAdapter;
import com.example.rejsedagbogapp.Database.TravelSQLHelper;
import com.example.rejsedagbogapp.R;

public class TravelsActivity extends AppCompatActivity {
    private final int REQUEST_CREATE_TRAVEL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);
        TravelSQLHelper.setApplicationContext(this);

        travelAdapter=new TravelCursorAdapter(this,


    }

    public void createTravelClick(View view) {
        Intent intent = new Intent(this, CreateTravelActivity.class);
        startActivityForResult(intent, REQUEST_CREATE_TRAVEL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CREATE_TRAVEL:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, "Travel entry succesfully added", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
