package com.example.rejsedagbogapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rejsedagbogapp.R;

public class JournalsActivity extends Activity {
    private final int REQUEST_CREATE_JOURNAL= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


    }
    public void createJournalClick(View view){
        Intent intent=new Intent(this,CreateJournalActivity.class);
        startActivityForResult(intent, REQUEST_CREATE_JOURNAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CREATE_JOURNAL:
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(this, "Journal entry succesfully added", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
