package com.example.gariboy.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gariboy.R;

public class MainActivity extends AppCompatActivity {


    TextView messages;
    Button history;
    String newString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messages =findViewById(R.id.main_text_messagees);
        history=findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),HistoryActivity.class);
                startActivity(intent);
            }
        });
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("state");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("state");
        }
        if(newString!=null){
            if(newString.equals("1")){
                Intent intent=new Intent(getBaseContext(),DangerActivity.class);
                startActivity(intent);
            }
        }


        //Intent intent = new Intent(getBaseContext(),HistoryActivity.class);
        //startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        Bundle extras = data.getExtras();
        if(extras == null) {
            newString= null;
        } else {
            newString= extras.getString("state");
        }
        if(newString!=null){
            if(newString.equals("1")){
                Intent intent=new Intent(getBaseContext(),DangerActivity.class);
                startActivity(intent);
            }
        }
    }

}
