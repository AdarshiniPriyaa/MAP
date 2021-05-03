package com.example.auctiontown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SellerMain extends AppCompatActivity {

    TextView bk1, bk2, bk3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellermain);
        bk1=(TextView)findViewById(R.id.bk1);
        bk2=(TextView)findViewById(R.id.bk2);
        bk3=(TextView)findViewById(R.id.bk3);
        bk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik = new Intent(SellerMain.this, Photo.class);
                startActivity(ik);
            }
        });
        bk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(SellerMain.this, Sample.class);
                startActivity(i2);
            }
        });
    }
}
