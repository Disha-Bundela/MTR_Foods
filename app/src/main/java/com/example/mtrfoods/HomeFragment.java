package com.example.mtrfoods;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    Button button ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        button = view.findViewById(R.id.btn_sub);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               FragmentVeg fragment =new FragmentVeg();
//              FragmentManager fragmentManager = getSupportFragmentManager();
//              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//              fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
//              fragmentTransaction.commit();
//            }
//        });

        return view;
    }



}
