package com.example.nikit.mydoctor.IninityViewPager;

import android.widget.TextView;

import com.example.nikit.mydoctor.DateFormat;


public class PageModel {

    private int index;
    private String text;
    public TextView textView;


    public PageModel(int index) {
        this.index = index;
        setIndex(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        String date = DateFormat.getPositionDay(index-1);

        this.text = date;
    }

    public String getText() {
        return text;
    }


}