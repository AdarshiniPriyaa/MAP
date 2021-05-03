package com.example.auctiontown;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity  {
    EditText e1, e2, e3;
    Button b31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        b31=(Button)findViewById(R.id.b31);
        final String mail= e2.getText().toString();
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user();
                DbHandler dh = new DbHandler(Register.this, "reg", null, 1);
                dh.insertValues(e1.getText().toString(), e2.getText().toString(), e3.getText().toString());
                Toast.makeText(getApplicationContext(), "SUBMITTED", Toast.LENGTH_LONG).show();
                emptyInputEditText();
                dh.close();

            }
            private void emptyInputEditText() {
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);
            }
            private void user(){
                if(Patterns.EMAIL_ADDRESS.matcher(mail).matches());
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }


        });



    }

}


