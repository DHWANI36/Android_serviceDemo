package com.example.dhwani_android.android_service_demo.services;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;

import com.example.dhwani_android.android_service_demo.R;

/**
 * Created by DHWANI-ANDROID on 08-05-17.
 */

public class DirectReplyIntent extends IntentService {

    public static String KEY_TEXT_REPLY = "key_text_reply";
    public static String KEY_NOTIFY_ID = "key_notify_id";

    public DirectReplyIntent() {
        super("DirectReplyIntent");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        CharSequence directReply = getMessageText(intent);
        if (directReply != null) {
            Notification repliedNotification =
                    new NotificationCompat.Builder(DirectReplyIntent.this)
                            .setSmallIcon(R.drawable.ic_launcher)
                            .setContentText("Received: " + directReply)
                            .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(
                    Context.NOTIFICATION_SERVICE);

            int notifyId = intent.getIntExtra(KEY_NOTIFY_ID, -1);
            notificationManager.notify(notifyId, repliedNotification);
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    private CharSequence getMessageText(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence(KEY_TEXT_REPLY);
        }
        return null;
    }
}
