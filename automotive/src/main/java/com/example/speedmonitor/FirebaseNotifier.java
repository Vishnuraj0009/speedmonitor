package com.example.speedmonitor;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FirebaseNotifier {

    public static void sendAlert(RentalConfig config, float currentSpeed) {
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("alerts")
                .push();

        Map<String, Object> data = new HashMap<>();
        data.put("customerId", config.customerId);
        data.put("currentSpeed", currentSpeed);
        data.put("maxAllowedSpeed", config.maxSpeed);
        data.put("timestamp", System.currentTimeMillis());

        ref.setValue(data);
    }

}
