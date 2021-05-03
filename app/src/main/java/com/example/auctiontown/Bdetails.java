package com.example.auctiontown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Bdetails extends AppCompatActivity {
        EditText p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bdetails);
        p1=(EditText)findViewById(R.id.p1);
        Intent i = getIntent();
        Bundle b= i.getExtras();
        String s= b.getString("map");
        p1.setText(s);
    }
}
