package com.databasedemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.databasedemo2.alaram_manager.AlaramManagerActivity;
import com.databasedemo2.audio_video.VideoActivity;
import com.databasedemo2.photo.CameraActiviy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(getApplicationContext(), VideoActivity.class));
               finish();
            }
        },2000);
    }
}