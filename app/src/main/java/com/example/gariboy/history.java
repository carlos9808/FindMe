package com.example.gariboy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class history extends AppCompatActivity {
    TextView messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        messages = findViewById(R.id.main_text_messagees);


        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        String msgData = "";
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                if (phoneNumber.equals("+528126342995")) {
                    msgData += cursor.getString(cursor.getColumnIndexOrThrow("body")) + " Numero:" + cursor.getString(cursor.getColumnIndexOrThrow("address"));
                }
                // use msgData
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }
        if (!msgData.isEmpty()) {
            messages.setText(msgData);
        }
    }
}


