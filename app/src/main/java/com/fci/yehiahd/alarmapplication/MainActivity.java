package com.fci.yehiahd.alarmapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int MY_NOTIFICATION_ID= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void notify(View view) {
        //Create a notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        //set notification data
        builder.setContentText("read Quran now")
                .setContentTitle("Quran")
                .setSmallIcon(R.drawable.readingquran)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setTicker("Quran Alert")
                .setColor(Color.RED);

        //to manage our notification built before <start or something else>
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //create an intent
        Intent intent = new Intent(this,Second.class);

        // wla lehom ay 60 lazma !
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(Second.class);
//        stackBuilder.addNextIntent(intent);

        //this pending intent allow to access our activity from outside of our application
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //set this pending intent feature to out notification Builder
        builder.setContentIntent(activity);

        //pop-up our notification built before using out manager
        manager.notify(MY_NOTIFICATION_ID,builder.build());
    }

    }
