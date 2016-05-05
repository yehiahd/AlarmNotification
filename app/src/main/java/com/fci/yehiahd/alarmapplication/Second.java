package com.fci.yehiahd.alarmapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class Second extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setAlarm();


    }

    public void setAlarm() {
        Intent intent = new Intent(this, AlertReceiver.class);
        AlarmManager alarmManager  = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, new GregorianCalendar().getTimeInMillis()+5*1000, PendingIntent.getBroadcast(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT));
    }

}
