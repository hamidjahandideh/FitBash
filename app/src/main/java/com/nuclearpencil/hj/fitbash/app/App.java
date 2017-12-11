package com.nuclearpencil.hj.fitbash.app;

import android.app.Application;

import com.hj.loginutil.UserUtil;
import com.nuclearpencil.hj.fitbash.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Hamid on 12/2/2016.
 */

public class App extends Application{

    public static UserUtil userUtil;

    @Override
    public void onCreate() {
        super.onCreate();

        userUtil=new UserUtil(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/BYEKAN.TTF").setFontAttrId(R.attr.fontPath).build());


    }




}
