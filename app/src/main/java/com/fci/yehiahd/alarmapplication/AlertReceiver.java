package com.fci.yehiahd.alarmapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

/**
 * Created by yehia on 05/05/16.
 */
public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        createNewNotification(context);
    }

    private void createNewNotification(Context context) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        //set notification data
        builder.setContentText("read Quran now")
                .setContentTitle("Quran")
                .setSmallIcon(R.drawable.readingquran)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setTicker("Quran Alert").setColor(Color.RED);

        //to manage our notification built before <start or something else>
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //create an intent
        Intent intent = new Intent(context,Second.class);

        //this pending intent allow to access our activity from outside of our application
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //set this pending intent feature to out notification Builder
        builder.setContentIntent(activity);

        //pop-up our notification built before using out manager
        manager.notify(1,builder.build());
    }
}
