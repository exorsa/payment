package com.example.pike.payment001.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pike.payment001.R;
import com.example.pike.payment001.model.Payment;

import java.util.List;


public class PaymentAdapter extends ArrayAdapter<Payment> {
    Activity activity;

    public PaymentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Payment> objects) {
        super(context, resource, objects);
        this.activity = (Activity) context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        Payment item = getItem(position);

        if (item != null){
            TextView textview = (TextView) itemView.findViewById(R.id.textview);

            textview.setText(item.getPrice());

        }
        return itemView;
    }
}
