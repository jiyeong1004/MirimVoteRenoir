package com.example.mirimvoterenoir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    Integer imageFileId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");
        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");
        TextView[] textVs = new TextView[imgNames.length];
        RatingBar[] ratingBars = new RatingBar[imgNames.length];

        int[] textIds = {R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7, R.id.text8, R.id.text9};
        int[] ratingIds = {R.id.rating_bar1, R.id.rating_bar2, R.id.rating_bar3, R.id.rating_bar4, R.id.rating_bar5, R.id.rating_bar6, R.id.rating_bar7, R.id.rating_bar8, R.id.rating_bar9};
        int[] imageFileId = {R.drawable.o1, R.drawable.o2, R.drawable.o3, R.drawable.o4, R.drawable.o5, R.drawable.o6, R.drawable.o7, R.drawable.o8, R.drawable.o9};

        int max = 0, maxIndex = 0;

        for(int i = 0; i < imgNames.length; i++){
            if(voteCount[i] > max){
                max = voteCount[i];
                maxIndex = i;
            }

            textVs[i] = findViewById(textIds[i]);
            ratingBars[i] = findViewById(ratingIds[i]);

            textVs[i].setText(imgNames[i]);
            ratingBars[i].setRating((float)voteCount[i]);
        }

        TextView textMaxTitle = findViewById(R.id.text_max_title);
        ImageView imgvMax = findViewById(R.id.imgv_max);

        textMaxTitle.setText(imgNames[maxIndex]);
        imgvMax.setImageResource(imageFileId[maxIndex]);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}