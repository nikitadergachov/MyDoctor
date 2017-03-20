package com.application.mydoctor.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.application.mydoctor.Activity.Basic.AnalyzActivity;
import com.application.mydoctor.Activity.Basic.MedicinesActivity;
import com.application.mydoctor.Activity.Basic.ProcedureActivity;
import com.application.mydoctor.Activity.Basic.RecomendationActivity;
import com.application.mydoctor.Activity.Basic.VizitActivity;
import com.application.mydoctor.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private PendingIntent pendingIntent;
    private NotificationManager notificationManager;
    private boolean isNotificActive;

    private static final int NOTIFY_ID = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       initImageView();



    }

    protected void initImageView(){
        ImageView medic = (ImageView) findViewById(R.id.medic_image_view);
        ImageView analyz = (ImageView) findViewById(R.id.analyz_image_view);
        ImageView procedure = (ImageView) findViewById(R.id.procedure_image_view);
        ImageView vizit = (ImageView) findViewById(R.id.vizit_image_view);
        ImageView settings = (ImageView) findViewById(R.id.setting_image_view);
        ImageView recomendation = (ImageView) findViewById(R.id.recomendation_image_view);

        medic.setOnClickListener(this);
        analyz.setOnClickListener(this);
        procedure.setOnClickListener(this);
        vizit.setOnClickListener(this);
        settings.setOnClickListener(this);
        recomendation.setOnClickListener(this);

       /* Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Medicines medicines = realm.createObject(Medicines.class); // Create a new object
        medicines.setName("John");
        realm.commitTransaction();
        RealmQuery<Medicines> query = realm.where(Medicines.class);

        RealmResults<Medicines> result1 = query.findAll();
        /*Log.d("fd", result1.toString());*//*
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm realm = Realm.getInstance(config);
        RealmInitData initData = new RealmInitData();
        initData.execute(realm);
        Calendar calendar = new GregorianCalendar();
        calendar.getInstance();
        calendar.set(2014, 11, 11, 14, 50, 30);
        Log.d("calendar date", calendar.get(Calendar.DATE)+"");
        Log.d("calendar month", calendar.get(Calendar.MONTH)+"");
        Log.d("calendar day of month", calendar.get(Calendar.DAY_OF_MONTH)+"");
        Log.d("day of week in month", calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"");


        Log.d("calendar time ", calendar.getTime()+"");*/


       /* Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm realm = Realm.getInstance(config);
       *//* RealmInitData initData = new RealmInitData();
        initData.execute(realm);*//*
        RealmResults<Analyzes> result = realm.where(Analyzes.class).findAll();
        result.sort("date");
        Analyzes analyzes = result.get(0);
        long date = analyzes.getDate();
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(date);
        Log.d("calendar date", calendar.get(Calendar.DATE)+"");
        Log.d("calendar month", calendar.get(Calendar.MONTH)+"");
        Log.d("calendar day of month", calendar.get(Calendar.DAY_OF_MONTH)+"");
        Log.d("day of week in month", calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"");*/










    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MenuActivity.this, MenuActivity.class);

        switch (v.getId()){
            case R.id.medic_image_view:
                intent = new Intent(MenuActivity.this, MedicinesActivity.class);
                startActivity(intent);
                break;
            case R.id.analyz_image_view:
                intent = new Intent(MenuActivity.this, AnalyzActivity.class);
                startActivity(intent);
                break;
            case R.id.procedure_image_view:
                intent = new Intent(MenuActivity.this, ProcedureActivity.class);
                startActivity(intent);
                break;
            case R.id.vizit_image_view:
                intent = new Intent(MenuActivity.this, VizitActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_image_view:
                try {
                    setAlarm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.recomendation_image_view:
                intent = new Intent(MenuActivity.this, RecomendationActivity.class);
                startActivity(intent);
                break;
        }

        //
    }


/*
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showNotification(){
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new
                NotificationCompat.Builder(this)
                .setContentTitle("Мой доктор")
                .setContentText("Тест")
                .setTicker("Alert new message")
                .setSmallIcon(R.drawable.pill);

        Intent intent = new Intent(this, MenuActivity.class);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);

        taskStackBuilder.addParentStack(MedicinesActivity.class);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        isNotificActive = true;
    }*/

    /*@RequiresApi(api = Build.VERSION_CODES.N)
    public void setAlarm(){
        Long alertTime = new GregorianCalendar().getTimeInMillis() + 50;

        Intent alertIntent = new Intent(this, AlarmReceiver.class);

        AlarmManager alarmManager = (AlarmManager)
                getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }*/


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setAlarm() throws InterruptedException {
        /*Calendar calendar = Calendar.getInstance();

        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                10, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long periodInMilisecond = 100;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                periodInMilisecond, periodInMilisecond, pendingIntent);*/

     /*   Context context = getApplicationContext();
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        int timeInterval = 1000;
        final AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        final PendingIntent pi = PendingIntent.getBroadcast(context, timeInterval, intent, 0);
        am.cancel(pi);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            final AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(System.currentTimeMillis() + timeInterval, pi);
            am.setAlarmClock(alarmClockInfo, pi);
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            am.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeInterval, pi);
        else
            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeInterval, pi);*/


          Context context = getApplicationContext();
        try {
            Thread.sleep(1000); //Приостанавливает поток на 1 секунду
        } catch (Exception e) {

        }

        Intent notificationIntent = new Intent(context, ProcedureActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = context.getResources();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Uri ringURI =
                RingtoneManager.getDefaultUri(R.raw.notification);

        long[] vibrate = new long[] { 1000, 1000, 1000, 1000, 1000 };

        Notification notification = new NotificationCompat.Builder(this)
                .setCategory(Notification.CATEGORY_PROMO)
                .setContentTitle("Напоминание")
                .setContentText("Необходимо выпить ромашковый чай!")
                .setSmallIcon(R.drawable.doctor)
                .setAutoCancel(true)
                .setVisibility(1)
                .addAction(android.R.drawable.ic_menu_view, "Подробнее", contentIntent)
                .setContentIntent(contentIntent)
                .setColor(Color.RED)
                .setLights(0xff00ff00, 300, 100)
                .setPriority(Notification.PRIORITY_HIGH)
                .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.notification))
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000}).build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }




}
