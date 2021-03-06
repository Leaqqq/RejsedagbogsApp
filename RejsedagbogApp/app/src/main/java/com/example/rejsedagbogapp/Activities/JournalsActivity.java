package com.example.rejsedagbogapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rejsedagbogapp.Adapters.JournalCursorAdapter;
import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.Database.TravelSQLHelper;
import com.example.rejsedagbogapp.R;

public class JournalsActivity extends AppCompatActivity {
    private final int REQUEST_CREATE_JOURNAL = 1;
    private JournalCursorAdapter journalAdapter;
    Travel travel = null;
    Long id=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journals);
        TravelSQLHelper.setApplicationContext(this);

        id = (Long) getIntent().getSerializableExtra("travelID");
        travel = Storage.getInstance().getTravel(id);
        Log.d("id fra travelID","ID'et"+id);
        Log.d("travel id","id fra travel"+travel.getId());
        journalAdapter = new JournalCursorAdapter(this, R.layout.journal_item, Storage.getInstance().getJournalsFromTravel(travel),
                new String[]{"TITLE"},
                new int[]{R.id.journalname}, 0);

        ListView journalsLw=findViewById(R.id.journalslw);
        journalsLw.setAdapter(journalAdapter);
        Log.d("KIG HER","TEST"+travel.getJournalsForTravel().toString());

        journalsLw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(JournalsActivity.this,JournalActivity.class);
                intent.putExtra("journal",id);
                JournalsActivity.this.startActivity(intent);

            }
        });



    }

    public void createJournalClick(View view) {
        Intent intent = new Intent(this, CreateJournalActivity.class);
        intent.putExtra("travelID",id);
        startActivityForResult(intent, REQUEST_CREATE_JOURNAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CREATE_JOURNAL:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, "Journal entry succesfully added", Toast.LENGTH_SHORT).show();
                        updateListview();

                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void updateListview() {
        journalAdapter.changeCursor(Storage.getInstance().getJournalsFromTravel(travel));
    }
}
