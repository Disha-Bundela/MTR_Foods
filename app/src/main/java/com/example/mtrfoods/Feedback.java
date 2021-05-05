package com.example.mtrfoods;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feedback extends Fragment {
    Button btn;
    RatingBar ratingbar;
    Button btn_sub;
    EditText ed_review;
    private FragmentActivity myContext;


    public Feedback() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn = view.findViewById(R.id.button);
        ratingbar=(RatingBar)view.findViewById(R.id.ratingBar);
        ed_review=view.findViewById(R.id.ed_reviews);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                    String rw = ed_review.getText().toString();
                    String rating=String.valueOf(ratingbar.getRating());
                    String msg = "Ratings : "+rating +"\n "+rw;
                    Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
