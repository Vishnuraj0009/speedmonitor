package com.example.speedmonitor;

import android.app.Service;
import android.car.Car;
import android.car.hardware.CarSensorEvent;
import android.car.hardware.CarSensorEventListener;
import android.car.hardware.CarSensorManager;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class SpeedMonitorService extends Service {

    private CarSensorManager carSensorManager;
    private RentalConfig rentalConfig;

    @Override
    public void onCreate() {
        super.onCreate();

        Car car = Car.createCar(this);
        carSensorManager = (CarSensorManager) car.getCarManager(Car.SENSOR_SERVICE);

        rentalConfig = new RentalConfig("customer123", 80.0f); // Config example

        carSensorManager.registerListener(new CarSensorEventListener() {
            @Override
            public void onSensorChanged(CarSensorEvent event) {
                float speed = event.floatValues[0];
                if (speed > rentalConfig.maxSpeed) {
                    AlertUtils.showDriverAlert(SpeedMonitorService.this, "You are exceeding the speed limit!");
                    FirebaseNotifier.sendAlert(rentalConfig, speed);
                }
            }
        }, CarSensorManager.SENSOR_TYPE_CAR_SPEED, CarSensorManager.SENSOR_RATE_NORMAL);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (carSensorManager != null) {
            carSensorManager.unregisterListener((CarSensorEventListener) this);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
