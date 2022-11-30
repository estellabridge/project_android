package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Pie_Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart = findViewById(R.id.pieChart);

        Intent receiveIntent = getIntent();
        int[] voutCount = receiveIntent.getIntArrayExtra("voteCount");
        String[] imgName = receiveIntent.getStringArrayExtra("imgName");

        ArrayList<PieEntry> languages = new ArrayList<>();
        for (int i = 0; i < voutCount.length; i++) {
            if (voutCount[i] == 0) {
                i = i+1;
            }
            else {
                languages.add(new PieEntry((float) voutCount[i], imgName[i]));
            }
        }

        PieDataSet pieDataSet = new PieDataSet(languages, "languages");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("결과");
        pieChart.animate();

        Button btnEnd = (Button) findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}