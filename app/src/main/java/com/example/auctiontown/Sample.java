package com.example.auctiontown;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sample extends AppCompatActivity {
    TextView tp1, tp2, tp3;
    Button bb1;
    private NestedScrollView lk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        tp1=(TextView)findViewById(R.id.tp1);
        tp2=(TextView)findViewById(R.id.tp2);
        tp3=(TextView)findViewById(R.id.tp3);
        lk=(NestedScrollView)findViewById(R.id.lk);
        bb1=(Button)findViewById(R.id.bb1);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbHandler dh = new DbHandler(Sample.this, "det", null, 1);
                dh.insertDet(tp1.getText().toString(),
                        Integer.parseInt(tp2.getText().toString()),
                        Integer.parseInt(tp3.getText().toString()));
                Snackbar.make(lk, "SUBMITTED", Snackbar.LENGTH_LONG).show();
                emptyInputEditText();
                dh.close();

            }
            private void emptyInputEditText() {
                tp1.setText(null);
                tp2.setText(null);
                tp3.setText(null);

            }
        });
    }
}
