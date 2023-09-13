package com.databasedemo2.alaram_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.databasedemo2.R;

public class AlaramManagerActivity extends AppCompatActivity {

    EditText ed;
    Button sub;
    AlarmManager manager;
    static final int REQUEST_CODE_PANDING_INTENT = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaram_manager);

        ed = findViewById(R.id.time);
        sub = findViewById(R.id.sub_time);
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time =Integer.parseInt(ed.getText().toString());

                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),100,new Intent(getApplicationContext(), TimeReciver.class), PendingIntent.FLAG_IMMUTABLE);

                manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(time*1000),pi); // time *1000 ti convert in ms
                Toast.makeText(getApplicationContext(), "alam set", Toast.LENGTH_SHORT).show();
            }
        });

    }
}