package com.example.minhtien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.minhtien.models.Tip;
import com.example.minhtien.tiptrips.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhtien on 8/18/2016.
 */
public class ListTipAdapter extends ArrayAdapter{
    private Context context;
    private ArrayList<Tip> arrTip;
    private LayoutInflater inflater;
    public ListTipAdapter(Context context, ArrayList objects) {
        super(context, R.layout.item_title, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arrTip = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_title,parent,false);
        TextView txtIndex = (TextView) convertView.findViewById(R.id.txt_index);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txt_title);
        txtIndex.setText(Integer.toString(position+1));
        txtTitle.setText(arrTip.get(position).getTitle());
        return convertView;
    }
}
