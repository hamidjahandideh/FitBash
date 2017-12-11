package com.nuclearpencil.hj.fitbash.view.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.view.activity.home.HomeActivity;
import com.nuclearpencil.hj.fitbash.view.fragment.ProgramDetailsFragment;

/**
 * Created by Hamid on 12/2/2017.
 */

public class ProgramViewHolder extends BaseViewHolder {

    ViewGroup rootView;
    TextView tv_title;
    ImageView iv;
//            ProgressView progressbar;


    public ProgramViewHolder(Context context,View itemView) {


        super(context,itemView);


        rootView = (ViewGroup) itemView;
        tv_title = (TextView) itemView.findViewById(R.id.tvName);


//                progressbar = (ProgressView) itemView.findViewById(R.id.progress);
    }


    @Override
    public void bind(Object object, final int position) {

        final ProgramModel programModel =(ProgramModel) object;

        tv_title.setText(programModel.getTitle());


/*
        Glide.with(context).load(programModel.getTags()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                    myholder.progressbar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                    myholder.progressbar.setVisibility(View.GONE);
                return false;
            }
        }).into(iv);*/

//            myholder.iv.setBackgroundResource(R.drawable.ic_movie_grey_50_24dp);// just for test mode

/*            Glide.with(getActivity())
                    .load(url)
                    .centerCrop()
//                                    .placeholder(R.drawable.loading_spinner)
                    .crossFade()
                    .into(iv);
            */

/*            imageLoader.get(programModel.getImage(), new ImageLoader.ImageListener() {//programModel.get("url")
                @Override
                public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {

                    if (imageContainer.getBitmap() != null) {
                        myholder.progressbar.setVisibility(View.GONE);
                        myholder.imageitem.setImageUrl(programModel.getImage(), imageLoader);
                    }
                }

                @Override
                public void onErrorResponse(VolleyError volleyError) {

                    //Toast.makeText(c, "Activity_Product_List error", Toast.LENGTH_SHORT).show();
                    myholder.progressbar.setVisibility(View.GONE);

                }
            });*/


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//or itemView.setOnClickListener
                HomeActivity activity=(HomeActivity) context;
                activity.pushFragment(new ProgramDetailsFragment());
            }
        });



    }

    @Override
    public void initWidgets(View view) {

    }

    @Override
    public void setListeners(View view) {

    }
}

