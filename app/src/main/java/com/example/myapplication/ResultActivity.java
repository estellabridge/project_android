package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.result);

        Intent receiveIntent = getIntent();
        int[] voteCount = receiveIntent.getIntArrayExtra("voteCount");
        String[] imgName = receiveIntent.getStringArrayExtra("imgName");

        TextView[] tv = new TextView[voteCount.length];
        RatingBar[] rBar = new RatingBar[voteCount.length];

        int[] tvId = {R.id.tv01, R.id.tv02, R.id.tv03, R.id.tv04, R.id.tv05, R.id.tv06, };
        int[] rBarId = {R.id.rBar01, R.id.rBar02, R.id.rBar03, R.id.rBar04, R.id.rBar05, R.id.rBar06};

        for (int i = 0; i < tv.length; i++) {
            tv[i] = (TextView) findViewById(tvId[i]);
            tv[i].setText(imgName[i]);

            rBar[i] = (RatingBar) findViewById(rBarId[i]);
            rBar[i].setRating((float) voteCount[i]);
        }
        btnReturn = (Button) findViewById(R.id.button);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
