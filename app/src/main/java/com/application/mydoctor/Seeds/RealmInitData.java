package com.application.mydoctor.Seeds;

import com.application.mydoctor.Model.Analyzes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import io.realm.Realm;

/**
 * Created by nikit on 19.03.2017.
 */

public class RealmInitData implements Realm.Transaction{
    @Override
    public void execute(Realm realm) {
        Analyzes analyzes = new Analyzes();
        realm.beginTransaction();
        Calendar calendar = new GregorianCalendar();
        calendar.set(2017, Calendar.MARCH, 25);

        analyzes.setName("Общий анализ крови");
        analyzes.setDescription("Время приёма крови с 7 до 9 утра\n Сдавать на тощак\n кабинет 10");
        analyzes.setDate(calendar.getTimeInMillis());
        realm.insertOrUpdate(analyzes);

        analyzes.setName("Анализ крови на гормоны");
        analyzes.setDescription("Время приёма крови с 7 до 9 утра\n Сдавать на тощак\n кабинет 10");
        calendar.set(2017, Calendar.MARCH, 28);
        analyzes.setDate(calendar.getTimeInMillis());
        realm.insertOrUpdate(analyzes);

        analyzes.setName("Анализ крови на сахар");
        analyzes.setDescription("Время приёма крови с 7 до 9 утра\n Сдавать на тощак\n кабинет 10");
        calendar.set(2017, Calendar.MARCH, 29);
        analyzes.setDate(calendar.getTimeInMillis());
        realm.insertOrUpdate(analyzes);
        realm.commitTransaction();

    }

    @Override
    public int hashCode() {
        return RealmInitData.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof RealmInitData;
    }
}
