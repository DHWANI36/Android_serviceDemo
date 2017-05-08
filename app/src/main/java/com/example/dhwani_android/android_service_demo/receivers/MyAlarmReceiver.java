package com.example.dhwani_android.android_service_demo.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;

import com.example.dhwani_android.android_service_demo.services.MySimpleService;

/**
 * Created by DHWANI-ANDROID on 08-05-17.
 */

public class MyAlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.codepath.example.servicesdemo.alarm";

    // Triggered by the Alarm periodically (starts the service to run task)
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MySimpleService.class);
        ResultReceiver receiver = intent.getParcelableExtra("receiver");
        i.putExtra("foo", "alarm!!");
        i.putExtra("receiver", receiver);
        context.startService(i);
    }
}
