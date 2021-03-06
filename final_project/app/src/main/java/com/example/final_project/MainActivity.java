package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String ANIMATION = "Animation";
    public static final String EXPLODE_ANIMATION = "Explode Animation";
    public static final String FADE_TRANSITION = "Fade Transition";
    Spinner spM, spD;
    public static final int TEXT_REQUEST = 1;
    int m,d,idM,idD;
    private static final String sharedPrefFile = "com.example.final_project";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spM = findViewById(R.id.spinnerM);
        spD = findViewById(R.id.spinnerD);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //Option Menu OnCreate
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
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
    public boolean onOptionsItemSelected(MenuItem item) {           //Option Menu Item OnClick
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                goAbout();
                return true;
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
            case R.id.github:
                Uri uri = Uri.parse("https://github.com/shashishajin/Android_Project");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public  void Calculate(View view){
        //??????????????????????????????????????????????????????
        String[] Sm =getResources().getStringArray(R.array.month);
        String[] Sd = getResources().getStringArray(R.array.date);

        //??????????????????????????????(??????????????????????????????)
        idM=spM.getSelectedItemPosition();
        idD=spD.getSelectedItemPosition();

        //?????????????????????
        m = Integer.parseInt(Sm[idM]);
        d = Integer.parseInt(Sd[idD]);


        //?????????????????????
        //4 6 9 11 ?????????31???
        if (m==4||m==6||m==9||m==11){
            if (d==31){
                Toast.makeText(this, "??????????????????", Toast.LENGTH_SHORT).show();
            }else{ goto2();}
            //2 ?????????30 31 ???
        }else if(m==2){
            if (d>29){
                Toast.makeText(this, "??????????????????", Toast.LENGTH_SHORT).show();
            }else{goto2();}
        } else{goto2();}
    }

    public void goto2() {
        //??????????????????????????????
        Intent itgo2 = new Intent();
        itgo2.setClass(MainActivity.this, SearchConstellation.class);
        itgo2.putExtra("m", m);
        itgo2.putExtra("d", d);
        Toast.makeText(this,"???????????????"+m+"???"+d+"???",Toast.LENGTH_SHORT).show();
        startActivity(itgo2);

    }

    public void goAbout() {
        //??????????????????????????????
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, About.class);
        startActivity(intent);

    }

    public void CheckAllConstellations(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CheckAllConstellations.class);
        startActivity(intent);
    }


    public void End (View view){
        //???????????????????????????????????????
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("????????????");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.setMessage("???????????????????????????????");
        adb.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        adb.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        adb.show();
    }

}