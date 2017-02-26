package com.example.nikit.mydoctor.InfinityViewPager;

import android.app.LauncherActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nikit.mydoctor.DateFormat;

/**
 * Created by nikit on 25.02.2017.
 */

public class PageModel {

    private int index;
    private String text;
    private String[] tabletNames;
    public TextView textView;
    public ListView listView;
    public LauncherActivity.ListItem listItem;


    public PageModel(int index) {
        this.index = index;
        setIndex(this.index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        String date = DateFormat.getPositionDay(index);
        this.text = date;
    }

    public String getText() {
        return text;
    }


}