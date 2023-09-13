package com.databasedemo2.alaram_manager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

public class TimeReciver extends BroadcastReceiver {

    MediaPlayer player ;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "play", Toast.LENGTH_SHORT).show();

        player = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();

    }
}
