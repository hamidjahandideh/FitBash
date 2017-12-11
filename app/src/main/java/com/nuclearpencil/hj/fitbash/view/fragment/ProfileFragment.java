package com.nuclearpencil.hj.fitbash.view.fragment;


import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nuclearpencil.hj.fitbash.R;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
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
        final View rootview = inflater.inflate(R.layout.fragment_profile, container, false);


        setAnimations(rootview);



        return rootview;

    }


    private void setAnimations(View rootview) {

        final ImageView img_fade = (ImageView) rootview.findViewById(R.id.img_fade);
        final ImageView img_progress=(ImageView) rootview.findViewById(R.id.img_progress);


        final Animation animFadein = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in);
        Animation animFadeout = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);
        final Animation animFadein_infinite = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in_infinite);
        final Animation animFadeout_infinite = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out_infinite);

        final Animation animRotate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        //animRotate.setInterpolator(new AccelerateDecelerateInterpolator());
        //animRotate.setInterpolator(new DecelerateInterpolator());
        //animRotate.setFillAfter(true);
        //animRotate.setFillEnabled(true);

        img_fade.startAnimation(animFadein_infinite);
        img_fade.startAnimation(animFadeout_infinite);




        final ProgressBar p_userstate = (ProgressBar) rootview.findViewById(R.id.p_userstate);
        p_userstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_fade.clearAnimation();
                img_fade.setVisibility(View.INVISIBLE);


                img_progress.setVisibility(View.VISIBLE);
                img_progress.startAnimation(animRotate);

                SystemClock.sleep(2500);


                Drawable progressDrawable = ContextCompat.getDrawable(getActivity(),R.drawable.ah_btnupdate_progressbar_progress_complete);
                Rect bounds = p_userstate.getProgressDrawable().getBounds();
                p_userstate.setProgressDrawable(progressDrawable);
                p_userstate.getProgressDrawable().setBounds(bounds);
                p_userstate.setProgress(99);
                p_userstate.setProgress(100);
                // progressDrawable.setBounds(p.getProgressDrawable().getBounds());
                //p.setProgressDrawable(progressDrawable);


                img_progress.clearAnimation();
                img_progress.setVisibility(View.GONE);

                img_fade.startAnimation(animFadein_infinite);
                img_fade.startAnimation(animFadeout_infinite);


            }
        });

    }




}
