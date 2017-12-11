package com.nuclearpencil.hj.fitbash.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutModel;
import com.nuclearpencil.hj.fitbash.view.holder.ExcerciseViewHolder;
import com.nuclearpencil.hj.fitbash.view.holder.WorkoutViewHolder;
import com.nuclearpencil.hj.fitbash.view.interfaces.ExcerciseItemClickListener;

/**
 * Created by Hamid on 11/27/2017.
 */

public class WorkoutAdapter extends RecyclerView.Adapter {

    Context context;
    LayoutInflater layoutInflater;
    WorkoutModel workoutModel;
    ExcerciseItemClickListener excerciseItemClickListener;
    int Header=0;
    int Item=1;


    public WorkoutAdapter(Context context, WorkoutModel workoutModel, ExcerciseItemClickListener excerciseItemClickListener) {

        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.workoutModel = workoutModel;
        this.excerciseItemClickListener = excerciseItemClickListener;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==Header){
            return new WorkoutViewHolder(context,layoutInflater.inflate(R.layout.view_holder_excercise_header,parent,false));
        }else if (viewType==Item){
            return new ExcerciseViewHolder(context,layoutInflater.inflate(R.layout.view_holder_excercise_item,parent,false));
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            WorkoutViewHolder workoutViewHolder = (WorkoutViewHolder) holder;
            workoutViewHolder.bind(workoutModel,-500);
        }else {
            ExcerciseViewHolder excerciseViewHolder = (ExcerciseViewHolder) holder;
            excerciseViewHolder.setExcerciseItemClickListener(excerciseItemClickListener);
            excerciseViewHolder.bind(workoutModel.getExerciseList().get(position-1),position-1);
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;//header
        }else {
            return 1;//item
        }

    }

    @Override
    public int getItemCount() {
        return workoutModel.getExerciseList().size()+1;//+1 for header
    }
}
