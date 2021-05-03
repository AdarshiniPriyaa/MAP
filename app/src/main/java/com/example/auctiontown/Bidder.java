package com.example.auctiontown;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

public class Bidder extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton appCompatButtonLogin;
    AppCompatTextView textViewLinkRegister;
    TextInputEditText textInputEditEmail, textInputEditPassword;
    DbHandler dh;
    private NestedScrollView layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bidder);
        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        layout=(NestedScrollView) findViewById(R.id.layout);
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
        initob();

    }

    public void initob() {
         dh = new DbHandler(Bidder.this, "reg", null, 1);

    }

    @Override
    public void onClick(View v) {
        textInputEditEmail = (TextInputEditText) findViewById(R.id.textInputEditEmail);
        textInputEditPassword = (TextInputEditText) findViewById(R.id.textInputEditPassword);

        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                verify();
                break;
            case R.id.textViewLinkRegister:
                Intent i = new Intent(Bidder.this, Register.class);
                startActivity(i);
                break;
        }

    }

    public void verify() {
        if (dh.checkAll(textInputEditEmail.getText().toString(), textInputEditPassword.getText().toString())) {
            Intent i1 = new Intent(Bidder.this, Bidding.class);
            i1.putExtra("EMAIL", textInputEditEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(i1);
        }
        else {
            Snackbar.make(layout, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();

        }
    }
    private void emptyInputEditText() {
        textInputEditEmail.setText(null);
        textInputEditPassword.setText(null);
    }

}

