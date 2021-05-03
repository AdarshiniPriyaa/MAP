package com.example.auctiontown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Results extends AppCompatActivity {
    EditText sk1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        sk1=(EditText)findViewById(R.id.sk1);
        Intent i = getIntent();
        Bundle b= i.getExtras();
        String s= b.getString("fat");
        sk1.setText(s);

    }
}
