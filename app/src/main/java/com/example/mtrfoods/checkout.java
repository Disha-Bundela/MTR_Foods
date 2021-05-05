package com.example.mtrfoods;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class checkout extends Fragment {

    int price;
    TextView textView;
    TextView textView_name;
    TextView textView_price;
    ImageView img;
    TimePicker simpleTimePicker;
    String item;
    Button order;

    public checkout(int p, String name) {
        price = p;
        item = name;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        textView=view.findViewById(R.id.textView1);
        textView_name=view.findViewById(R.id.txt_name);
        textView_price=view.findViewById(R.id.txt_price);
        order=view.findViewById(R.id.button);
        simpleTimePicker = (TimePicker) view.findViewById(R.id.timePicker2);


        textView_price.setText(price+" Rs");
        price +=50; //delivery charge
        String msg = "Total Price : "+price+" Rs.";
        textView.setText(msg);
        textView_name.setText(item);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    int hours = simpleTimePicker.getHour();
                    int min = simpleTimePicker.getMinute();
                    String msg = "Order Successfully Placed.\n Estimated Delivery at " + hours + ":" + min + " \nItem : " + item;
                    Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }
}
