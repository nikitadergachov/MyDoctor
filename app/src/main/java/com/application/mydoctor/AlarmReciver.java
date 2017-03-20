package com.application.mydoctor;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.application.mydoctor.Activity.MenuActivity;


public class AlarmReciver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        createNotification(context, "gfsgs", "fsdfsd", "Alert");
        Log.d("fsdfsdfs","1");

    }

    public void createNotification(Context context, String msg, String msgText, String msgAlert){
        PendingIntent notificIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MenuActivity.class), 0);
        Log.d("fsdfsdfs","2");
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.pill)
                .setContentTitle(msg)
                .setContentText(msgText)
                .setTicker(msgAlert);

        mBuilder.setContentIntent(notificIntent);

        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);

        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, mBuilder.build());
    }
}
