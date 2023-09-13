package com.databasedemo2.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.databasedemo2.R;

public class AccelerometerSensor extends AppCompatActivity implements SensorEventListener {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_sensor_light);
        tv = findViewById(R.id.values);
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (manager != null)
        {
            Sensor light = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(light != null)
            {
                manager.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else Toast.makeText(this, "No light fount", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "No sensor fount", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            tv.setText("X :" + sensorEvent.values[0]
                    + "Y :" +sensorEvent.values[1]+
                    "z : " + sensorEvent.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}