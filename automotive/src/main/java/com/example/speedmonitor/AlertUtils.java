package com.example.speedmonitor;

import android.content.Context;
import android.widget.Toast;

public class AlertUtils {
    public static void showDriverAlert(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
