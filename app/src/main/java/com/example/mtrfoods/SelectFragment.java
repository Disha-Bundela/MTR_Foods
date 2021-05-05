package com.example.mtrfoods;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {

    public SelectFragment() {
        // Required empty public constructor
    }

    Button button;
    private FragmentActivity myContext;


//    @Override
//    public void onAttach(@NonNull Context context) {
//        myContext=(FragmentActivity) activity;
//        super.onAttach(context);
//    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RadioGroup radioGroup = (RadioGroup) view .findViewById(R.id.rg);
        button = view.findViewById(R.id.btn_sub);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentVeg fragment =new FragmentVeg();
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch(checkedId) {
                    case R.id.rb_in:
                        FragmentVeg fragment =new FragmentVeg();
                        FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.main_framelayout, fragment, null);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.rb_out:
                        FragmentNonveg fragment1 =new FragmentNonveg();
                        FragmentManager fragmentManager1 = myContext.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.main_framelayout, fragment1, null);
                        fragmentTransaction1.addToBackStack(null);
                        fragmentTransaction1.commit();
                        break;
                }
//                group.clearCheck();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        RadioGroup radioGroup = (RadioGroup) myContext.findViewById(R.id.rg);
        radioGroup.clearCheck();
        super.onResume();
    }
}

