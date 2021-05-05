package com.example.mtrfoods;

import android.app.Activity;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVeg extends Fragment {

    CardView pizza;
    CardView dhosa;
    CardView sandwich;
    CardView cake;
    private FragmentActivity myContext;

    public FragmentVeg() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_veg, container, false);

        pizza = view.findViewById(R.id.cd_pizza);
        dhosa = view.findViewById(R.id.cd_dhosa);
        sandwich = view.findViewById(R.id.cd_sandwich);
        cake = view.findViewById(R.id.cd_cake);

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Pizza",Toast.LENGTH_SHORT).show();
                checkout fragment =new checkout( 100 , "pizza" );
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        dhosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"dhosa",Toast.LENGTH_SHORT).show();
                checkout fragment =new checkout( 150 , "dhosa" );
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"sandwich",Toast.LENGTH_SHORT).show();
                checkout fragment =new checkout( 200 ,"sandwich");
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"cake",Toast.LENGTH_SHORT).show();
                checkout fragment =new checkout( 300 ,"cake");
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}
