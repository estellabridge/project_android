package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnVoteFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] votecount = new int[6];

        for (int i = 0; i<votecount.length; i++)
            votecount[i] = 0;

        ImageView[] image = new ImageView[6];

        int []imageId = {R.id.image1, R.id.image2, R.id.image3, R.id.image4, R.id.image5, R.id.image6 };

        final String[] imgName = {"asm", "c", "cpp", "java", "python", "gp"};

        for (int i = 0; i < votecount.length; i++) {
            final int index;
            index = i;

            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public  void onClick(View v) {
                    votecount[index]++;
                    Toast.makeText(MainActivity.this, imgName[index] + "이 총" + votecount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
            btnVoteFinish = (Button)findViewById(R.id.btnVoteEnd);
            btnVoteFinish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    sendIntent.putExtra("imgName", image);
                    sendIntent.putExtra("voteCount", votecount);
                    startActivity(sendIntent);
                }
            });
        }
    }

}