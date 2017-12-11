package com.nuclearpencil.hj.fitbash.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.view.activity.home.HomeActivity;




public class ProgramFragment extends Fragment {


    public ProgramFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //String strtext = getArguments().getString("edttext");
        final View rootview = inflater.inflate(R.layout.fragment_program, container, false);

        CardView cv_template= (CardView) rootview.findViewById(R.id.cv_template);
        CardView cv_newprogram= (CardView) rootview.findViewById(R.id.cv_newprogram);


        cv_template.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity activity=(HomeActivity) getActivity();
                activity.pushFragment(new FindProgramFragment());
//                startActivity(new Intent(getContext(), ProgramListActivity.class));
            }
        });

        cv_newprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity activity=(HomeActivity) getActivity();
                activity.pushFragment(new NewProgramFragment());

            }
        });

        return rootview;

    }






}
