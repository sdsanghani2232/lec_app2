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

public class ProximitySensor extends AppCompatActivity  implements SensorEventListener {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        tv = findViewById(R.id.values1);
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (manager != null)
        {
            Sensor proxi = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if(proxi != null)
            {
                manager.registerListener(this,proxi, SensorManager.SENSOR_DELAY_NORMAL);
            }
            else Toast.makeText(this, "No light fount", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "No sensor fount", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY)
        {
            tv.setText("value : " + sensorEvent.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}