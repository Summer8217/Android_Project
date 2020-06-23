package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bumptech.glide.Glide;

public class ConstellationDetail extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_constellations_detail);

        TextView ConstellationTitle = findViewById(R.id.titleDetail);
        ImageView ConstellationImage = findViewById(R.id.sportsImageDetail);
        TextView ConstellationInfo = findViewById(R.id.subTitleDetail);
        Intent intent = getIntent();
        String titleString = intent.getStringExtra("title");        //取得title
        String SubDetail = intent.getStringExtra("detail");         //取得描述
        int imageInt = intent.getIntExtra("image_resource", 0);     //取得圖片

        ConstellationTitle.setText(titleString);
        ConstellationInfo.setText(SubDetail);
        Glide.with(this).load(imageInt).into(ConstellationImage);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nightMode = AppCompatDelegate.getDefaultNightMode();
                if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void goAbout() {
        //將日期傳至下一個頁面
        Intent intent = new Intent();
        intent.setClass(ConstellationDetail.this, About.class);
        startActivity(intent);

    }
}
