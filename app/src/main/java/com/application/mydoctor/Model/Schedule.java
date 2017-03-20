package com.application.mydoctor.Model;

import io.realm.RealmObject;

/**
 * Created by nikit on 18.03.2017.
 */

public class Schedule extends RealmObject {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private long time;


}
