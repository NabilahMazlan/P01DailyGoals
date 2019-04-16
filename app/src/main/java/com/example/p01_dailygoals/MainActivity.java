package com.example.p01_dailygoals;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1,rg2,rg3;
    Button btn1;
    TextView multiText;
    RadioButton rb1, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = findViewById(R.id.radioGroup1);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        btn1 = findViewById(R.id.buttonOK);
        multiText = findViewById(R.id.editTextMultiline);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectID1 = rg1.getCheckedRadioButtonId();
                int selectID2 = rg2.getCheckedRadioButtonId();
                int selectID3 = rg3.getCheckedRadioButtonId();

                rb1 = findViewById(selectID1);
                rb2 = findViewById(selectID2);
                rb3 = findViewById(selectID3);


                String stringrb1 = rb1.getText().toString();
                String stringrb2 = rb2.getText().toString();
                String stringrb3 = rb3.getText().toString();

                String multipleText = multiText.getText().toString();

                SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putInt("rb1", selectID1);
                editor.putInt("rb2", selectID2);
                editor.putInt("rb3", selectID3);
                editor.putString("multitext", multipleText);
                editor.commit();

                String info[] = { stringrb1, stringrb2, stringrb3, multipleText };

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("info", info);
                startActivity(intent);


            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        int stringrb1 = rg1.getCheckedRadioButtonId();
        int stringrb2 = rg2.getCheckedRadioButtonId();
        int stringrb3 = rg3.getCheckedRadioButtonId();
        String multipleText = multiText.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
         editor.putInt("rb1", stringrb1);
         editor.putInt("rb2", stringrb2);
        editor.putInt("rb3", stringrb3);
        editor.putString("multitext", multipleText);

        editor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int rb1 = pref.getInt("rb1", 1);
        int rb2 = pref.getInt("rb2", 1);
        int rb3 = pref.getInt("rb3", 1);
        String text = pref.getString("multitext", "");

        rg1.check(rb1);
        rg2.check(rb2);
        rg3.check(rb3);
        multiText.setText(text);


    }
}
