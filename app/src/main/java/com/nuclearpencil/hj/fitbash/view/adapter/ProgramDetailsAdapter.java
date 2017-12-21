package com.nuclearpencil.hj.fitbash.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutWeekModel;
import com.nuclearpencil.hj.fitbash.view.holder.ProgramDetailsHeaderViewHolder;
import com.nuclearpencil.hj.fitbash.view.holder.WorkoutWeekViewHolder;

import java.util.ArrayList;

/**
 * Created by Hamid on 11/27/2017.
 */

public class ProgramDetailsAdapter extends RecyclerView.Adapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<WorkoutWeekModel> items;

    int VIEW_TYPE_HEADER=0;
    int VIEW_TYPE_ITEM=1;


    public ProgramDetailsAdapter(Context context, ArrayList<WorkoutWeekModel> items) {

        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType==VIEW_TYPE_HEADER){
            return new ProgramDetailsHeaderViewHolder(context,layoutInflater.inflate(R.layout.view_holder_program_details_header,parent,false));
        }else if (viewType==VIEW_TYPE_ITEM){
            return new WorkoutWeekViewHolder(context,layoutInflater.inflate(R.layout.view_holder_workout_week_item,parent,false));
        }else {
            return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position==0){
            ProgramDetailsHeaderViewHolder headerViewHolder = (ProgramDetailsHeaderViewHolder) holder;
            headerViewHolder.bind(null,-500);
        }else {
            final WorkoutWeekViewHolder myholder = (WorkoutWeekViewHolder) holder;
            myholder.bind(items.get(position-1),position-1);
        }


    }


    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return VIEW_TYPE_HEADER;//header
        }else {
            return VIEW_TYPE_ITEM;//item
        }

    }



    @Override
    public int getItemCount() {
        return items.size()+1;//+1 for header
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
