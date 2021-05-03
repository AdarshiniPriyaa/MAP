package com.example.auctiontown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
    EditText ap1, ap2;
    Button y1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        y1=(Button)findViewById(R.id.b8);
        ap1=(EditText)findViewById(R.id.ap1);
        ap2=(EditText)findViewById(R.id.ap2);
        y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ap1.getText().toString().equals("USER") && ap2.getText().toString().equals("USER")) {
                    Intent s = new Intent(Admin.this, Admindetails.class);
                    startActivity(s);
                }
                else {
                    Toast.makeText(getApplicationContext(), "INVALID USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();
                }
            }


        });
    }
}
