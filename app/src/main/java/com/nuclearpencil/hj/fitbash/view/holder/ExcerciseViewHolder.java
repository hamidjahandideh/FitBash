package com.nuclearpencil.hj.fitbash.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.ExerciseModel;
import com.nuclearpencil.hj.fitbash.view.interfaces.ExcerciseItemClickListener;

/**
 * Created by Hamid on 11/27/2017.
 */

public class ExcerciseViewHolder extends BaseViewHolder{

    LinearLayout rootview;
    TextView tvNumber, tvName,tvMuscles,tvEquipment,tvExerciseType,tvTotalRepeats,tvSets;
    ImageView ivPicture1,ivPicture2;
    ExcerciseItemClickListener excerciseItemClickListener;
    ExerciseModel exerciseModel;

    public ExcerciseViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    public void bind(Object object, int position) {
        if (object instanceof ExerciseModel){

        }
        exerciseModel = (ExerciseModel) object;

        tvNumber.setText(String.valueOf(position));
        tvName.setText(exerciseModel.getName());
        tvMuscles.setText(exerciseModel.getMuscleTarget());
        tvEquipment.setText(exerciseModel.getEquipment());
        tvExerciseType.setText(exerciseModel.getExerciseType());
        tvTotalRepeats.setText(String.format("%s سری تکرار می شود",exerciseModel.getExerciseType()));
        tvSets.setText(String.format("%s ست",exerciseModel.getExerciseType()));

    }

    @Override
    public void initWidgets(View view) {
        rootview = (LinearLayout) itemView;
        tvNumber = (TextView) itemView.findViewById(R.id.tv_number);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvMuscles = (TextView) itemView.findViewById(R.id.tvMuscles);
        tvEquipment = (TextView) itemView.findViewById(R.id.tvEquipment);
        tvExerciseType = (TextView) itemView.findViewById(R.id.tvExerciseType);
        tvTotalRepeats = (TextView) itemView.findViewById(R.id.tvTotalRepeats);
        tvSets = (TextView) itemView.findViewById(R.id.tvSets);
        ivPicture1 = (ImageView) itemView.findViewById(R.id.ivPicture1);
        ivPicture2 = (ImageView) itemView.findViewById(R.id.ivPicture2);

    }


    @Override
    public void setListeners(View view) {

        rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excerciseItemClickListener.onClick(exerciseModel);
            }
        });

    }


    public void setExcerciseItemClickListener(ExcerciseItemClickListener excerciseItemClickListener) {
        this.excerciseItemClickListener = excerciseItemClickListener;
    }

}
