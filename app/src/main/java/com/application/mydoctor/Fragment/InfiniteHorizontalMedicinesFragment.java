package com.application.mydoctor.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.application.mydoctor.Activity.MainActivity;
import com.application.mydoctor.Adapter.TabletArrayAdapter;
import com.application.mydoctor.Helper.DataHelper;
import com.application.mydoctor.R;

import cn.pedant.SweetAlert.SweetAlertDialog;
import pro.alexzaitsev.freepager.library.view.infinite.Constants;
import pro.alexzaitsev.freepager.library.view.infinite.InfiniteHorizontalPagerAdapter;
import pro.alexzaitsev.freepager.library.view.infinite.ViewFactory;


public class InfiniteHorizontalMedicinesFragment extends Fragment implements ViewFactory {

    private int mBgColor;


    final String[] tablet_name = new String[]{
            "Паратетамол", "Эспумизан", "Милдронат", "Фенибут",
            "Луналдин", "Анастезин", "Кадионат", "Триметазин",
            "Рибоксин", "Предуктал МВ", "Валидол", "Моносан"
    };
    final int[] count = {
            1, 1, 2, 2,
            2, 3, 1, 2,
            1, 1, 2, 3
    };

    final String[] time = new String[]{
            "8:20", "8:20", "8:40", "9:20",
            "10:10", "10:20", "11:05", "12:00",
            "13:00", "13:00", "15:40", "21:40"
    };

    final String[] time_check = new String[]{
            "8:25", "8:30", "8:40", "9:30",
            "10:25", "10:30", "11:25", "13:00",
            null, null, null, null
    };





    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RelativeLayout layout = (RelativeLayout) inflater.inflate(
                R.layout.activity_medicines, container, false);
        ViewPager verticalPager = (ViewPager)layout.findViewById(R.id.medicines_view_pager);

        if(verticalPager.getParent()!=null)
            ((ViewGroup)verticalPager.getParent()).removeView(verticalPager); // <- fix

        verticalPager.setAdapter(new InfiniteHorizontalPagerAdapter(this, 0));
        verticalPager.setCurrentItem(Constants.START_INDEX);

        return verticalPager;
    }

    @Override
    public View makeView(int vertical, int horizontal) {
        ListView listView = new ListView(getActivity());
        TabletArrayAdapter arrayAdapter = new TabletArrayAdapter(getActivity(),
                tablet_name, count, time, time_check);
        listView.setAdapter(arrayAdapter);

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.medicines_header,listView, false);
        listView.addHeaderView(header, null, false);

        TextView textView = (TextView)header.findViewById(R.id.data);
        TextView textDayOfWeek = (TextView)header.findViewById(R.id.day_of_week);


        DataHelper.getPositionDay(horizontal);
        textView.setText(DataHelper.getPositionDay(horizontal+1));
        textDayOfWeek.setText(DataHelper.getDayOfWeekRus());


        ImageView imageView = (ImageView)header.findViewById(R.id.back_menu);

        Log.d("f", imageView.toString());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("Принять " + tablet_name[position-1] + "?")
                                .setConfirmText("Да")
                                .setCancelText("Пропустить")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();
                                    }
                                })
                                .show();
                    }
                }
        );




        return listView;
    }
}
