package com.nuclearpencil.hj.fitbash.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutWeekModel;
import com.nuclearpencil.hj.fitbash.view.holder.WorkoutWeekViewHolder;

import java.util.ArrayList;

/**
 * Created by Hamid on 11/27/2017.
 */

public class WorkoutWeekAdapter extends RecyclerView.Adapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<WorkoutWeekModel> items;
    int Header=0;
    int Item=1;


    public WorkoutWeekAdapter(Context context, ArrayList<WorkoutWeekModel> items) {

        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WorkoutWeekViewHolder(context,layoutInflater.inflate(R.layout.view_holder_workout_week_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WorkoutWeekViewHolder workoutWeekViewHolder = (WorkoutWeekViewHolder) holder;
        workoutWeekViewHolder.bind(items,position);
    }



    @Override
    public int getItemCount() {
        return items.size();//+1 for header
    }


    public void addItems(ArrayList<WorkoutWeekModel> items) {
        if (items!=null && items.size()>0){
            this.items.addAll(items);
            notifyDataSetChanged();
        }
    }

    public void setItems(ArrayList<WorkoutWeekModel> items) {
        if (items!=null && items.size()>0) {
            this.items = items;
            notifyDataSetChanged();
        }
    }


}
