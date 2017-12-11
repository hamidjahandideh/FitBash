package com.nuclearpencil.hj.fitbash.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutModel;

/**
 * Created by Hamid on 11/27/2017.
 */

public class WorkoutViewHolder extends BaseViewHolder{

    LinearLayout rootview;
    TextView  tvName,tvGoal,tvLevel,tvGender,tvMusclesInvolved,tvCreator,tvTotalCardio,tvTotalExercise,tvTotalSet,tvTotalTime;
    ImageView ivPicture1;
    public WorkoutViewHolder(Context context, View itemView) {
        super(context, itemView);

        rootview = (LinearLayout) itemView;
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvGoal = (TextView) itemView.findViewById(R.id.tvGoal);
        tvLevel = (TextView) itemView.findViewById(R.id.tvLevel);
        tvMusclesInvolved = (TextView) itemView.findViewById(R.id.tvMusclesInvolved);
        tvCreator = (TextView) itemView.findViewById(R.id.tvCreator);
        tvTotalCardio = (TextView) itemView.findViewById(R.id.tvTotalCardio);
        tvTotalExercise = (TextView) itemView.findViewById(R.id.tvTotalExercise);
        tvTotalSet = (TextView) itemView.findViewById(R.id.tvTotalSet);
        tvTotalTime = (TextView) itemView.findViewById(R.id.tvTotalTime);


    }

    @Override
    public void bind(Object object, int position) {
        if (!(object instanceof WorkoutModel)){
            return;
        }

        WorkoutModel workoutModel = (WorkoutModel) object;

        tvName.setText(String.valueOf(position));
        tvGoal.setText(workoutModel.getName());
        tvLevel.setText(workoutModel.getName());
//        tvGender.setText(workoutModel.getName());
        tvMusclesInvolved.setText(workoutModel.getName());
        tvCreator.setText(workoutModel.getName());
        tvTotalCardio.setText(workoutModel.getName());
        tvTotalExercise.setText(workoutModel.getName());
        tvTotalSet.setText(workoutModel.getName());
        tvTotalTime.setText(workoutModel.getName());


    }

    @Override
    public void initWidgets(View view) {

    }

    @Override
    public void setListeners(View view) {

    }

}
