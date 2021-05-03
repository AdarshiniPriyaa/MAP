package com.example.auctiontown;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class Game extends AppCompatActivity {
    Timer timer;
    Button j1;
    EditText tk1, tk2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        tk1=(EditText)findViewById(R.id.tk1);
        tk2=(EditText)findViewById(R.id.tk2);
        j1=(Button)findViewById(R.id.j1);
        j1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler dh = new DbHandler(Game.this, "details", null, 1);
                dh.insertDetails(tk1.getText().toString(), Integer.parseInt(tk2.getText().toString()));
                Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_LONG).show();
                dh.close();

            }

        });
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i1= new Intent(Game.this, Sad.class);
                startActivity(i1);
                finish();
            }
        }, 10000);




    }
}
