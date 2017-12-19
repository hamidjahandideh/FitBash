package com.nuclearpencil.hj.fitbash.view.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alirezaafkar.sundatepicker.DatePicker;
import com.alirezaafkar.sundatepicker.interfaces.DateSetListener;
import com.nuclearpencil.hj.fitbash.R;

import java.util.Calendar;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NewWorkoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);



        new DatePicker.Builder()
                .id(3)
//                .theme(theme)
                .date(1395,10,10)
                .build(new DateSetListener() {
                    @Override
                    public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {

                    }
                })
                .show(getSupportFragmentManager(), "");
    }





}
