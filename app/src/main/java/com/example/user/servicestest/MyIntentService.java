package com.example.user.servicestest;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyIntentService extends IntentService {
    private int x = 0;
    private static final String TAG="MyT";
    public MyIntentService() {
        super("HelloIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        while (true) {
            Log.d(TAG,String.valueOf(x));
            if((x%50)==0){
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Title")
                                .setContentText(String.valueOf(x));

                Notification notification = builder.build();

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(x, notification);
            }
            x++;
        }
    }
}
