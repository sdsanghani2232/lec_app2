package com.databasedemo2.audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.databasedemo2.R;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController controller;
    public int videoPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.video);

        String path = "android.resource://"+getPackageName()+"/raw/v1";

        Uri offline = Uri.parse(path);
        videoView.setVideoURI(offline);
        //videoView.setVideoPath(path);
        videoView.start();

        controller = new MediaController(this);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        

    }

}