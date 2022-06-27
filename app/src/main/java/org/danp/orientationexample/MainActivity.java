package org.danp.orientationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
     SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
     Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
     Sensor sensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
     sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
     sensorManager.registerListener(sensorEventListener2, sensor1, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onSensorChanged(SensorEvent event) {
            EditText x = findViewById(R.id.m_x);
            EditText y = findViewById(R.id.m_y);
            EditText z = findViewById(R.id.m_z);

            /*
             * values[0] = x_uncalib
             * values[1] = y_uncalib
             * values[2] = z_uncalib
             * values[3] = x_bias
             * values[4] = y_bias
             * values[5] = z_bias
             */

            x.setText("Magnetic X: "+(int) event.values[0]);
            y.setText("Magnetic Y: "+(int) event.values[1]);
            z.setText("Magnetic Z: "+(int) event.values[2]);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private SensorEventListener sensorEventListener2 = new SensorEventListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onSensorChanged(SensorEvent event) {
            EditText x = findViewById(R.id.a_x);
            EditText y = findViewById(R.id.a_y);
            EditText z = findViewById(R.id.a_z);

            /*
             * values[0]: Acceleration minus Gx on the x-axis (if supported)
             * values[1]: Acceleration minus Gy on the y-axis (if supported)
             * values[2]: Acceleration minus Gz on the z-axis (if supported)
             * values[3]: Acceleration supported for x-axis
             * values[4]: Acceleration supported for y-axis
             * values[5]: Acceleration supported for z-axis
             */

            x.setText("Accelerometer X: "+(int) event.values[0]);
            y.setText("Accelerometer Y: "+(int) event.values[1]);
            z.setText("Accelerometer Z: "+(int) event.values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}