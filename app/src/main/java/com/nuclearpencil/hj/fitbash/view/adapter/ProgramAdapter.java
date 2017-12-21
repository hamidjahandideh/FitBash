package com.nuclearpencil.hj.fitbash.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.view.holder.FindProgramHeaderViewHolder;
import com.nuclearpencil.hj.fitbash.view.holder.ProgramViewHolder;

import java.util.ArrayList;

/**
 * Created by Hamid on 12/2/2017.
 */

public class ProgramAdapter extends RecyclerView.Adapter {


    ArrayList<ProgramModel> items;
    Context context;
    LayoutInflater layoutInflater;
    public static int VIEW_TYPE_HEADER=0;
    public static int VIEW_TYPE_ITEM=1;


    public ProgramAdapter(Context context, ArrayList<ProgramModel> items) {
        this.items = items;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType==VIEW_TYPE_HEADER){
            return new FindProgramHeaderViewHolder(context,layoutInflater.inflate(R.layout.view_holder_find_program_header,parent,false));
        }else if (viewType==VIEW_TYPE_ITEM){
            return new ProgramViewHolder(context,layoutInflater.inflate(R.layout.view_holder_program_item, parent, false));
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position==0){
            FindProgramHeaderViewHolder headerViewHolder = (FindProgramHeaderViewHolder) holder;
            headerViewHolder.bind(null,-500);
        }else {
            final ProgramViewHolder myholder = (ProgramViewHolder) holder;
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


    public void addItems(ArrayList<ProgramModel> items) {
        if (items!=null && items.size()>0){
            this.items.addAll(items);
            notifyDataSetChanged();
        }
    }

    public void setItems(ArrayList<ProgramModel> items) {
        if (items!=null && items.size()>0) {
            this.items = items;
            notifyDataSetChanged();
        }
    }
}
