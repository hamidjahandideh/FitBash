package com.nuclearpencil.hj.fitbash.web.api;

import com.google.gson.JsonObject;
import com.hj.userutil.model.UserModel;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


// Define the Endpoints
// https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit

/**
 * Created by Hamid on 12/16/2015.
 */
public interface ServiceApi {


    //http://mofid.xyz/api/auth.php?mode=login&username=admin&password=admin
    @GET("api/auth.php?mode=login")
    Call<ServiceResponse<UserModel>> login(@Query("username") String username, @Query("password") String password);

    //http://mofid.xyz/api/auth.php?mode=login&username=admin&password=admin
    @GET("api/auth.php?mode=isloggedin")
    Call<ServiceResponse<JsonObject>> isloggedin();


    //http://192.168.1.40:2081/FindClassmate.svc/User_Register?hardwareid=hardwareID&name=name&family=family&birthyear=birthyear&mobile=mobile&pass=pass&hometown=hometown&job=job
    @GET("api/get.php?mode=getVideos")
    Call<ServiceResponse<ArrayList<ProgramModel>>> getList(@Query("page") int page);//@Query("userid") int userid


}
