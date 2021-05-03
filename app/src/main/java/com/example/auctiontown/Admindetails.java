package com.example.auctiontown;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Admindetails extends AppCompatActivity {
    Button w1, button11;
    SQLiteDatabase dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindetails);
        w1=(Button)findViewById(R.id.w1);
        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler dh = new DbHandler(Admindetails.this, "reg", null, 1);
                String s= dh.selectRows();
                Intent i = new Intent(Admindetails.this, Bdetails.class);
                Bundle b= new Bundle();
                b.putString("map", s);
                i.putExtras(b);
                startActivity(i);

            }
        });
        button11=(Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DbHandler dh= new DbHandler(Admindetails.this, "details", null, 1);
              String e= dh.selectRows1();
             Intent i2= new Intent(Admindetails.this, Results.class);
             Bundle b1= new Bundle();
                b1.putString("fat", e);
                i2.putExtras(b1);
                startActivity(i2);
            }
        });
    }
}

