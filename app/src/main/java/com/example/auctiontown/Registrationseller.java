package com.example.auctiontown;


import android.os.Bundle;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class Registrationseller extends AppCompatActivity {
    TextInputEditText ww1, ww2, ww3, ww4;
    AppCompatButton r1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationseller);
        ww1=(TextInputEditText)findViewById(R.id.ww1);
        ww2=(TextInputEditText)findViewById(R.id.ww2);
        ww3 = (TextInputEditText) findViewById(R.id.ww3);
        ww4 = (TextInputEditText) findViewById(R.id.ww4);
        r1 = (AppCompatButton) findViewById(R.id.r1);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler dh = new DbHandler(Registrationseller.this, "seller", null, 1);
                dh.inserting(ww1.getText().toString(), ww2.getText().toString(), ww3.getText().toString(), ww4.getText().toString());
                Toast.makeText(getApplicationContext(), "SUBMITTED", Toast.LENGTH_LONG).show();
                emptyInputEditText();
                dh.close();
            }

            private void emptyInputEditText() {
                ww1.setText(null);
                ww2.setText(null);
                ww3.setText(null);
                ww4.setText(null);
            }
        });
    }
}


