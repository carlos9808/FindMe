package com.example.gariboy.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gariboy.R;

public class MainActivity extends AppCompatActivity {


    TextView messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages =findViewById(R.id.main_text_messagees);


        //Intent intent = new Intent(getBaseContext(),HistoryActivity.class);
        //startActivity(intent);



    }


}
