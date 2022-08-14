package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        getSupportActionBar().hide();
        setContentView(R.layout.activity_second);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(SecondActivity.this , MainActivity.class));
              finish();
            }
        } , 1900);
    }
}