package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import javax.xml.transform.TransformerConfigurationException;

public class MainActivity extends AppCompatActivity {

    Spinner spM, spD;
    public static final int TEXT_REQUEST = 1;
    int m,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spM = findViewById(R.id.spinnerM);
        spD = findViewById(R.id.spinnerD);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                goAbout();
                return true;
            case R.id.night_mode:
                int nightMode = AppCompatDelegate.getDefaultNightMode();
                if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                    Toast.makeText(this,"aaa",Toast.LENGTH_SHORT).show();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else {
                    Toast.makeText(this,"bbb",Toast.LENGTH_SHORT).show();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public  void Calculate(View view){
        //指定字串陣列，對應到資源檔的字串陣列
        String[] Sm =getResources().getStringArray(R.array.month);
        String[] Sd = getResources().getStringArray(R.array.date);

        //取得被選擇的項目編號(各個選單有各自的編號)
        int idM=spM.getSelectedItemPosition();
        int idD=spD.getSelectedItemPosition();

        //取的對應到的值
        m = Integer.parseInt(Sm[idM]);
        d = Integer.parseInt(Sd[idD]);

        //錯誤日期的判斷
        //4 6 9 11 月沒有31號
        if (m==4||m==6||m==9||m==11){
            if (d==31){
                Toast.makeText(this, "日期輸入錯誤", Toast.LENGTH_SHORT).show();
            }else{ goto2();}
            //2 月沒有30 31 號
        }else if(m==2){
            if (d>29){
                Toast.makeText(this, "日期輸入錯誤", Toast.LENGTH_SHORT).show();
            }else{goto2();}
        } else{goto2();}
    }

    public void goto2() {
        //將日期傳至下一個頁面
        Intent itgo2 = new Intent();
        itgo2.setClass(MainActivity.this, Constellation1.class);
        itgo2.putExtra("m", m);
        itgo2.putExtra("d", d);
        startActivity(itgo2);

    }

    public void goAbout() {
        //將日期傳至下一個頁面
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
        //以對話框確認是否要關閉視窗
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("確認視窗");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.setMessage("確定要結束應用程式嗎?");
        adb.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        adb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        adb.show();
    }
}