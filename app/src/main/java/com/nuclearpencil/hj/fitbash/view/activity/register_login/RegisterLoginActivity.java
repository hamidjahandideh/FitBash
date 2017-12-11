package com.nuclearpencil.hj.fitbash.view.activity.register_login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.hj.internetviewer.model.ResponseNullException;
import com.hj.loginutil.data.model.StateType;
import com.hj.loginutil.data.model.UserModel;
import com.hj.loginutil.data.model.UserType;
import com.hj.loginutil.interfaces.OnLoginStateChange;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.app.App;
import com.nuclearpencil.hj.fitbash.app.ge_WC;
import com.nuclearpencil.hj.fitbash.util.ToastUtil;
import com.nuclearpencil.hj.fitbash.view.activity.home.HomeActivity;
import com.nuclearpencil.hj.fitbash.web.api.ServiceApi;
import com.nuclearpencil.hj.fitbash.web.api.ServiceResponse;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegisterLoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.userUtil.addListener(new OnLoginStateChange() {
            @Override
            public void onLoginStateChange(StateType stateType, UserModel user) {

            }
        });

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

/*        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);*/

        setContentView(R.layout.activity_register_login);


        final RelativeLayout rl_start =(RelativeLayout)findViewById(R.id.rl_start);
        TextView tv_register =(TextView)findViewById(R.id.tv_register);
        TextView tv_login =(TextView)findViewById(R.id.tv_login);
        final TextView tv_birthday =(TextView)findViewById(R.id.tv_birthday);

        final LinearLayout ll_login =(LinearLayout)findViewById(R.id.ll_login);
        final LinearLayout ll_register =(LinearLayout)findViewById(R.id.ll_register);
        ImageView iv_r_back =(ImageView)findViewById(R.id.iv_r_back);
        ImageView iv_l_back =(ImageView)findViewById(R.id.iv_l_back);
        Button b_login =(Button) findViewById(R.id.b_login);
        Button b_register =(Button) findViewById(R.id.b_register);


        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_start.setVisibility(View.GONE);
                ll_register.setVisibility(View.VISIBLE);
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_start.setVisibility(View.GONE);
                ll_login.setVisibility(View.VISIBLE);
            }
        });


        iv_r_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_register.setVisibility(View.GONE);
                rl_start.setVisibility(View.VISIBLE);
            }
        });



        iv_l_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_login.setVisibility(View.GONE);
                rl_start.setVisibility(View.VISIBLE);
            }
        });



        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel user=new UserModel(UserType.Normal,"1","hamid","asdasd","http://www.google.com","www.asdsad@sdasdas.com","13123123213");
                App.userUtil.setLogin(user);


                final EditText et_l_username =(EditText)findViewById(R.id.et_l_username);
                final EditText et_l_password =(EditText)findViewById(R.id.et_l_password);

                String username = et_l_username.getText().toString();
                String password = et_l_password.getText().toString();

                if (username.length()<4) {
                    et_l_username.setError("نام کاربری نباید کمتر از 4 کاراکتر باشد");
                    et_l_username.requestFocus();
                    return;
                }

                if (password.length()<4) {
                    et_l_password.setError("رمز عبور نباید کمتر از 4 رقم باشد");
                    et_l_password.requestFocus();
                    return;
                }


                login(username,password);


                startActivity(new Intent(getBaseContext(), HomeActivity.class));
            }
        });

        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), HomeActivity.class));
            }
        });





        final PersianDatePickerDialog[] picker = new PersianDatePickerDialog[1];
        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picker[0] = new PersianDatePickerDialog(RegisterLoginActivity.this)
                        .setPositiveButtonString("باشه")
                        .setNegativeButton("بیخیال")
                        .setTodayButton("امروز")
                        .setTodayButtonVisible(true)
//                        .setInitDate(initDate)
                        .setMaxYear(1400)
                        .setMinYear(1300)
                        .setActionTextColor(Color.GRAY)
//                        .setTypeFace(typeface)
                        .setListener(new Listener() {
                            @Override
                            public void onDateSelected(PersianCalendar persianCalendar) {
                                tv_birthday.setText(persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay());
                            }

                            @Override
                            public void onDisimised() {

                            }
                        });

                picker[0].show();

            }
        });




        //playVideo(); putted in onResume()

    }




    private void login(final String username, final String password) {


        ServiceApi api = ge_WC.retrofitJSON.create(ServiceApi.class);
        final Call<ServiceResponse<UserModel>> call = api.login(username, password);
        call.enqueue(new Callback<ServiceResponse<UserModel>>() {
            @Override
            public void onResponse(Call<ServiceResponse<UserModel>> call, Response<ServiceResponse<UserModel>> response) {

//                p_loading.setVisibility(View.GONE);
                ServiceResponse<UserModel> result = response.body();
                UserModel user = result.getData();
                if (user != null) {
//                    if (login.getStatus().equalsIgnoreCase("success")){
                    if (result.getMsg().equalsIgnoreCase("success")) {
                        App.userUtil.setLogin(user);
                        ToastUtil.ShowToast(RegisterLoginActivity.this,"ورود با موفقیت انجام شد");
                        startActivity(new Intent(getBaseContext(),HomeActivity.class));
                    }else if (result.getMsg().equalsIgnoreCase("error occured!"))
                        ToastUtil.ShowToast(RegisterLoginActivity.this, "در ورود خطایی رخ داده است");
                    else if (result.getMsg().equalsIgnoreCase("User Doesn’t Exist")){
                        ToastUtil.ShowToast(RegisterLoginActivity.this, "این نام کاربری موجود نیس ");
                    }else {
                        ToastUtil.ShowToast(RegisterLoginActivity.this, "نام کاربری یا کلمه ی عبور اشتباه وارد شده است");
                    }


                } else {
                    onFailure(call,new ResponseNullException("error sended of onResponse -> response = null "));
                }

/*

//                p_loadCity.setVisibility(View.GONE);

                SortUtil sortUtil = new SortUtil();
                Map<String, CategoryData> category = sortUtil.SortByAlphabet(categoryData);

                ArrayList<mCategory> cities = response.body();
                if (cities!=null && cities.size()!=0) {
                    listview.setVisibility(View.VISIBLE);
                    ArrayList<String> listItems = new ArrayList<>();
                    for (int i=0;i<cities.size();i++)
                    {
                        listItems.add(cities.get(i).getCategoryDetail());
                    }



                }else {
                    listview.setVisibility(View.GONE);
                }*/

            }


            @Override
            public void onFailure(Call<ServiceResponse<UserModel>> call, Throwable t) {

//                p_loading.setVisibility(View.GONE);
                ToastUtil.ShowToast(RegisterLoginActivity.this, "اتصال به اینترنت را بررسی کنید");




            }

        });

    }





    @Override
    protected void onResume() {
        super.onResume();
        playVideo();
    }



    private void playVideo() {

        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
//        mediaController.setAnchorView(videoView);
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_540_25);
//        videoView.setMediaController(mediaController);

        videoView.setVideoURI(uri);
        videoView.setFitsSystemWindows(true);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView.start();

    }





    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
