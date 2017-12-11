package com.nuclearpencil.hj.fitbash.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.view.holder.ProgramViewHolder;

import java.util.ArrayList;

/**
 * Created by Hamid on 12/8/2017.
 */

public class ProgramListViewAdapter extends BaseAdapter{

    ArrayList<ProgramModel> items;
    Context context;
    LayoutInflater layoutInflater;

    public ProgramListViewAdapter(Context context, ArrayList<ProgramModel> items) {
        this.items = items;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.view_holder_program_item, viewGroup, false);
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
