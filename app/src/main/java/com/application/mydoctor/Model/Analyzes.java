package com.application.mydoctor.Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.RealmClass;

/**
 * Created by nikit on 18.03.2017.
 */
@RealmClass
public class Analyzes extends RealmObject implements RealmModel {

    private String name;
    private long date;
    private long receiptOfDate;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getReceiptOfDate() {
        return receiptOfDate;
    }

    public void setReceiptOfDate(long receiptOfDate) {
        this.receiptOfDate = receiptOfDate;
    }

    public static RealmResults<Analyzes> getAllAnalyzes(Realm realm){

        return realm.where(Analyzes.class).findAll();
    }

    public static void setReceiptTime(int position, Realm realm){
        Calendar calendar = GregorianCalendar.getInstance();
        long time = calendar.getTimeInMillis();
        realm.beginTransaction();
        RealmResults<Analyzes> realmResults = realm.where(Analyzes.class).findAll();
        realmResults.get(position).setReceiptOfDate(time);
        realm.commitTransaction();
    }

}
