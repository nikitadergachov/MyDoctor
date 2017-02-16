package com.example.nikit.mydoctor;

import java.sql.Date;
import java.util.Calendar;


public class DateFormat {
    private static DateFormat ourInstance = new DateFormat();

    public static DateFormat getInstance() {
        return ourInstance;
    }

    private static Calendar calendar;

    private DateFormat() {
        calendar = Calendar.getInstance();
    }


    private static String MonthRus(){
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);
        switch (month){
            case 0:
                return "Января";
            case 1:
                return "Февраля";
            case 2:
                return "Марта";
            case 3:
                return "Апреля";
            case 4:
                return "Мая";
            case 5:
                return "Июня";
            case 6:
                return "Июля";
            case 7:
                return "Августа";
            case 8:
                return "Сентября";
            case 9:
                return "Октября";
            case 10:
                return "Ноября";
            case 11:
                return "Декабря";
            default:
                return "";
        }
    }

    private static String DateRus(){
        return calendar.get(Calendar.DAY_OF_MONTH) + " " + MonthRus();
    }

    public static void getCurrentDateRus(){
        calendar = Calendar.getInstance();
        DateRus();
    }

    public static void getNextDay(){
        calendar.add(Calendar.DATE, 1);
        DateRus();
    }

    public static void getPreviousDay(){
        calendar.add(Calendar.DATE, -1);
        DateRus();
    }

    public static String getPositionDay(int position){
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, position);
        return DateRus();
    }

    public static int getDate(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(){
        return calendar.get(Calendar.MONTH);
    }

    public static int getYers(){
        return calendar.get(Calendar.YEAR);
    }
}
