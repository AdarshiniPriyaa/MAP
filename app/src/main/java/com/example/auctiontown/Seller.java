package com.example.auctiontown;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;

public class Seller extends AppCompatActivity implements View.OnClickListener{
   AppCompatButton bn1;
   AppCompatTextView bn2;
   DbHandler dh;
    TextInputEditText k1, k2;
    private NestedScrollView bat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller);
        bn1=(AppCompatButton)findViewById(R.id.bn1);
        bn2=(AppCompatTextView)findViewById(R.id.bn2);
        bat=(NestedScrollView)findViewById(R.id.bat);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
        initob();
    }
    public void initob() {
        dh = new DbHandler(Seller.this, "seller", null, 1);

    }

    @Override
    public void onClick(View v) {
        k1=(TextInputEditText)findViewById(R.id.k1);
        k2=(TextInputEditText)findViewById(R.id.k2);
        switch (v.getId()){
            case R.id.bn1:
            verify();
            break;
            case  R.id.bn2:
            Intent i = new Intent(Seller.this, Map.class);
            startActivity(i);
            break;
        }
    }

    public void verify(){
        if(dh.checkdata(k1.getText().toString(), k2.getText().toString())){
            Intent i2= new Intent(Seller.this, SellerMain.class);
            i2.putExtra("USERNAME", k1.getText().toString().trim());
            emptyInputEditText();
            startActivity(i2);
        }
        else {
            Snackbar.make(bat, "ENTER THE VALID USERNAME AND PASSWORD", Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        k1.setText(null);
        k2.setText(null);
    }
}
