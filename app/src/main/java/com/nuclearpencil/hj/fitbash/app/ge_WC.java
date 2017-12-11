package com.nuclearpencil.hj.fitbash.app;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by hamid.jahandideh on 12/1/15.
 * email : hamid.jahandideh@yahoo.com
 */
public class ge_WC {

    //    public static String BaseAddress = "http://mofid.xyz/";
    public static String BaseAddress = "http://188.253.2.80/~videoshia/demo/276/";


    public static OkHttpClient okHttpClient = new OkHttpClient.Builder() // this is just use for set time out now
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

    public static Retrofit retrofitJSON = new Retrofit.Builder()
            .baseUrl(BaseAddress)
            .client(okHttpClient)// not need , just for test
            .addConverterFactory(GsonConverterFactory.create())// must exist
            .build();


    public static Retrofit retrofitString = new Retrofit.Builder()
            .baseUrl(BaseAddress)
            .addConverterFactory(ScalarsConverterFactory.create())// must exist
            .build();






}
