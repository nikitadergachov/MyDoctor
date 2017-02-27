package com.example.nikit.mydoctor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;


public class TabletArrayAdapter extends ArrayAdapter<String> {

    private final Activity contex;
    private final String[] name;
    private final int[] count;
    private final String[] time;
    private final String[] time_check;


    public TabletArrayAdapter(Activity contex, String[] name, int[] count, String[] time, String[] time_check) {
        super(contex,R.layout.custom_list_item, name);
        this.contex = contex;
        this.name = name;
        this.count = count;
        this.time = time;
        this.time_check = time_check;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = contex.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.custom_list_item, null, true);

        TextView tabletName = (TextView)listItemView.findViewById(R.id.tablet_name);
        TextView tabletCount = (TextView)listItemView.findViewById(R.id.count);
        TextView tabletTime = (TextView)listItemView.findViewById(R.id.receipt_time);
        TextView checkTime = (TextView)listItemView.findViewById(R.id.time_check);
        ImageView checkImage = (ImageView)listItemView.findViewById(R.id.check_image);

        tabletName.setText(name[position]);
        tabletCount.setText("Количество " + count[position]);
        tabletTime.setText(time[position]);
        if(this.time_check[position] != null){
            checkTime.setText("Принято " + time_check[position]);
            checkImage.setImageResource(R.drawable.check);
        }
        else
            checkImage.setImageResource(R.drawable.no_check);
        return listItemView;
    }
}
