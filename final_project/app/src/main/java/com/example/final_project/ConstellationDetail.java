package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ConstellationDetail extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_constellations_detail);

        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);
        TextView ConstellationInfo = findViewById(R.id.subTitleDetail);
        Intent intent = getIntent();
        String titleString = intent.getStringExtra("title");        //取得title
        String SubDetail = intent.getStringExtra("detail");         //取得描述
        int imageInt = intent.getIntExtra("image_resource", 0);     //取得圖片

        sportsTitle.setText(titleString);
        ConstellationInfo.setText(SubDetail);
        Glide.with(this).load(imageInt).into(sportsImage);
    }
}
