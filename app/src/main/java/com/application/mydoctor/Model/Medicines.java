package com.application.mydoctor.Model;


import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class Medicines extends RealmObject implements RealmModel{

    private String name;
    private long time;
    private long timeOfReceipt;
    private int count;
    private String type;

    public long getTimeOfReceipt() {
        return timeOfReceipt;
    }

    public void setTimeOfReceipt(long timeOfReceipt) {
        this.timeOfReceipt = timeOfReceipt;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }
}
