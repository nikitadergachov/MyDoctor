package com.application.mydoctor.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.application.mydoctor.R;

;

public class VizitArrayAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] typeDoctor;
    private final String[] time;
    private final String[] date;


    public VizitArrayAdapter(Activity context, String[] typeDoctor, String[] time, String[] date) {
        super(context, R.layout.medicines_item, typeDoctor);
        this.context = context;
        this.typeDoctor = typeDoctor;
        this.time = time;
        this.date = date;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.vizit_item, null, true);

        TextView typeView = (TextView)listItemView.findViewById(R.id.type_doctor_text_view);
        TextView dateView = (TextView)listItemView.findViewById(R.id.data_text_view);
        TextView timeView = (TextView)listItemView.findViewById(R.id.time_text_view);

        typeView.setText(typeDoctor[position]);
        dateView.setText(date[position]);
        timeView.setText(time[position]);

        return listItemView;
    }
}
