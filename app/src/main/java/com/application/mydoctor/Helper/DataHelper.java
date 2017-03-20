package com.application.mydoctor.Helper;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class DataHelper {
    private static DataHelper ourInstance = new DataHelper();

    public static DataHelper getInstance() {
        return ourInstance;
    }

    private static Calendar calendar;

    private DataHelper() {
        calendar = Calendar.getInstance();
    }


    private static String MonthRus(){
        int month = calendar.get(Calendar.MONTH);
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
        calendar.add(Calendar.DATE, position  );
        return DateRus();
    }

    public static String getDayOfWeekRus(){
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek){
            case 1 :
                return "Воскресенье";
            case 2 :
                return "Понедельник";
            case 3 :
                return "Вторник";
            case 4 :
                return "Среда";
            case 5 :
                return "Четверг";
            case 6 :
                return "Пятница";
            case 7 :
                return "Суббота";
            default:
                return "";
        }
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

    public static String monthRus(int month) {
        switch (month) {
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

    public static String getConverDateToStringRus(long timeMils){
        Calendar date = new GregorianCalendar();
        date.setTimeInMillis(timeMils);
        int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);

        return dayOfMonth + " " + monthRus(month);
    }
}
