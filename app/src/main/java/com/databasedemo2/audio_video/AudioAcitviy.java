package com.databasedemo2.audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.databasedemo2.R;

import java.io.IOException;

public class AudioAcitviy extends AppCompatActivity {

    Button play,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_acitviy);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop= findViewById(R.id.stop);


        MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String path = "android.resource://"+getPackageName()+"/raw/f1";
        String onlinepath = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

        Uri adiouri = Uri.parse(path);
        Uri online = Uri.parse(onlinepath);
        try {
//            player.setDataSource(this,adiouri);
            player.setDataSource(this,online);
            player.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
                player.seekTo(0);//set on time
            }
        });

        player.getDuration();// time duration
        player.getCurrentPosition(); // current time

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //that use on play list
                // that work on audio complete
            }
        });

    }
}