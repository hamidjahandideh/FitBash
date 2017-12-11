package com.nuclearpencil.hj.fitbash.view.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutModel;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutWeekModel;

/**
 * Created by Hamid on 11/27/2017.
 */

public class WorkoutWeekViewHolder extends BaseViewHolder{

    ViewGroup rootview;
    TextView  tvName;
    ImageView ivPicture1;
    public WorkoutWeekViewHolder(Context context, View itemView) {
        super(context, itemView);

        rootview = (ViewGroup) itemView;
//        tvName = (TextView) itemView.findViewById(R.id.tvName);



    }

    @Override
    public void bind(Object object, int position) {
        if (!(object instanceof WorkoutModel)){
            return;
        }

        WorkoutWeekModel workoutModel = (WorkoutWeekModel) object;

//        tvName.setText(String.valueOf(position));



    }

    @Override
    public void initWidgets(View view) {

    }

    @Override
    public void setListeners(View view) {

    }

}
