package com.nuclearpencil.hj.fitbash.view.holder;

/**
 * Created by Hamid on 11/21/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {


    protected Context context;
    protected LayoutInflater layoutInflater;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        initWidgets(itemView);
        setListeners(itemView);
    }

    public abstract void bind(Object object, int position);


    public abstract void initWidgets(View view);

    public abstract void setListeners(View view);


}
