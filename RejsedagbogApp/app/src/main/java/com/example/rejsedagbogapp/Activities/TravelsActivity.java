package com.example.rejsedagbogapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rejsedagbogapp.Adapters.TravelCursorAdapter;
import com.example.rejsedagbogapp.Classes.Travel;
import com.example.rejsedagbogapp.Database.Storage;
import com.example.rejsedagbogapp.Database.TravelSQLHelper;
import com.example.rejsedagbogapp.R;
import com.example.rejsedagbogapp.Wrappers.TravelCursorWrapper;

public class TravelsActivity extends AppCompatActivity {
    private final int REQUEST_CREATE_TRAVEL = 1;

    private TravelCursorAdapter travelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);
        registerForContextMenu(findViewById(R.id.travelslw));
        TravelSQLHelper.setApplicationContext(this);

        travelAdapter = new TravelCursorAdapter(this,
                R.layout.travel_item,
                Storage.getInstance().getTravels(),
                new String[]{"DESTINATION"},
                new int[]{R.id.travelname},
                0);
        ListView travelsListView = findViewById(R.id.travelslw);
        travelsListView.setAdapter(travelAdapter);

        travelsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TravelsActivity.this, TravelActivity.class);
                intent.putExtra("travel", id);
                TravelsActivity.this.startActivity(intent);
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId()==R.id.travelslw){
            ListView lv=(ListView)v;
            AdapterView.AdapterContextMenuInfo acmi=(AdapterView.AdapterContextMenuInfo) menuInfo;
            TravelCursorWrapper item=(TravelCursorWrapper)lv.getItemAtPosition(acmi.position);
            menu.setHeaderTitle("Choose");
            menu.add("Delete");

        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Long id=travelAdapter.getItemId(info.position);

        if (item.getTitle() == "Delete") {
            Storage.getInstance().deleteTravel(id);
            updateListview();
            View contextView = findViewById(R.id.travelslw);

            Snackbar.make(contextView, "Rejse slettet", Snackbar.LENGTH_SHORT)
                    .show();
        }
        return true;
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
                        updateListview();
                        
                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void updateListview() {
    travelAdapter.changeCursor(Storage.getInstance().getTravels());
    }

}
