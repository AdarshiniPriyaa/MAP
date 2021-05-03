package com.example.auctiontown;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Bidding extends AppCompatActivity {
TextView tex;
ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biding);
        TextView tex= (TextView)findViewById(R.id.tex);
        tex.setSelected(true);
        imageView1=(ImageView)findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Bidding.this, Laptop.class);
                startActivity(i1);
            }
        });
    }

}
