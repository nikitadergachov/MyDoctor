package com.application.mydoctor.Adapter;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.mydoctor.Helper.DataHelper;
import com.application.mydoctor.Model.Analyzes;
import com.application.mydoctor.R;

import io.realm.RealmResults;

public class AnalyzesArrayAdapter extends ArrayAdapter<Analyzes>{

    private final RealmResults<Analyzes> analyzesResult;
    private final Activity context;

    public AnalyzesArrayAdapter(Activity context, RealmResults<Analyzes> analyzesResult) {
        super(context, R.layout.analyz_item, analyzesResult);
        this.context = context;
        this.analyzesResult = analyzesResult;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.analyz_item, null, true);

        TextView typeView = (TextView)listItemView.findViewById(R.id.name_analyz);
        TextView dateView = (TextView)listItemView.findViewById(R.id.data_text_view);
        TextView timeView = (TextView)listItemView.findViewById(R.id.time_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.check);

        Analyzes analyz = analyzesResult.get(position);

        //typeView.setText("Шишкевич");

        typeView.setText(analyz.getName());
        analyz.getDate();
      /*  dateView.setText(date[position]);
        timeView.setText(time[position]);
        if(check[position])
            imageView.setImageResource(R.drawable.check);*/


        if(analyz.getReceiptOfDate()!= 0) {
            imageView.setImageResource(R.drawable.check);
            dateView.setText(DataHelper.getConverDateToStringRus(analyz.getReceiptOfDate()));
        }
        else
            dateView.setText(DataHelper.getConverDateToStringRus(analyz.getDate()));





        return listItemView;
    }
}
