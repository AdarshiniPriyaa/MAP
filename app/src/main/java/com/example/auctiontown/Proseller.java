package com.example.auctiontown;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

public class Proseller extends AppCompatActivity {
    TextInputEditText y1, y2, y3, y4;
    Button bu;
    private NestedScrollView AK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proseller);
        y1=(TextInputEditText)findViewById(R.id.y1);
        y2=(TextInputEditText)findViewById(R.id.y2);
        y3=(TextInputEditText)findViewById(R.id.y3);
        y4=(TextInputEditText)findViewById(R.id.y4);
        AK=(NestedScrollView)findViewById(R.id.AK);
        bu=(Button)findViewById(R.id.bu);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler dh = new DbHandler(Proseller.this, "product", null, 1);
                dh.insertPro(y1.getText().toString(), y2.getText().toString(), y3.getText().toString()
                        , Integer.parseInt(y4.getText().toString()));
                Snackbar.make(AK, "SUBMITTED", Snackbar.LENGTH_LONG).show();
                emptyInputEditText();
                dh.close();
            }
            private void emptyInputEditText() {
                y1.setText(null);
                y2.setText(null);
                y3.setText(null);
                y4.setText(null);
            }
        });



    }


}

