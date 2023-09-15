package com.databasedemo2.audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.databasedemo2.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController controller;
    CircularProgressIndicator circularProgressIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        circularProgressIndicator = findViewById(R.id.loder);

        videoView = findViewById(R.id.video);

        String path = "android.resource://"+getPackageName()+"/raw/v1";

        Uri offline = Uri.parse(path);
        videoView.setVideoURI(offline);
        //videoView.setVideoPath(path);
        videoView.start();

        controller = new MediaController(this);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);

        circularProgressIndicator.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                circularProgressIndicator.setVisibility(View.GONE);
            }
        },4000);

    }

}