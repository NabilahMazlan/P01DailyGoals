package com.example.p01_dailygoals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class Main2Activity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        btnClose = findViewById(R.id.buttonClose);

        Intent intent = getIntent();

        String[] info = intent.getStringArrayExtra("info");

        tv1.setText(getResources().getString(R.string.materials) + ": " + info[0]);
        tv2.setText(getResources().getString(R.string.arrival) + ": " + info[1]);
        tv3.setText(getResources().getString(R.string.attempt) + ": " + info[2]);
        tv4.setText("Reflection: " + info[3]);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}
