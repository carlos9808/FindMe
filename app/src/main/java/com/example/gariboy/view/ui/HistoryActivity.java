package com.example.gariboy.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.example.gariboy.R;
import com.example.gariboy.data.LocationPing;
import com.example.gariboy.view.adapter.AdapterHistory;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {


    RecyclerView historyLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyLocations = findViewById(R.id.recicler_history);



        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        String msgData = "";
        List<LocationPing> locationPings = new ArrayList<>();
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String phoneNumber =cursor.getString(cursor.getColumnIndexOrThrow("address"));
//                if(phoneNumber.equals("+528126342995")) {
                    LocationPing locationPing = new LocationPing();
                    locationPing.setLocation(cursor.getString(cursor.getColumnIndexOrThrow("body")));
                    locationPing.setPhoneNumber(cursor.getString(cursor.getColumnIndexOrThrow("address")));
                    locationPings.add(locationPing);
//                }
                // use msgData
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }


        AdapterHistory viewAdapter = new AdapterHistory(getBaseContext(), locationPings);
        historyLocations.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        historyLocations.setAdapter(viewAdapter);

    }
}
