package com.nuclearpencil.hj.fitbash.view.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutModel;

import java.util.ArrayList;
import java.util.Stack;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends AppCompatActivity {

    FragmentManager fragmentManager=getSupportFragmentManager();
    Stack<Fragment> fragments=new Stack<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }




    public void pushFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_base, fragment).addToBackStack("");
        fragmentTransaction.commit();

        // set the toolbar title
        //getSupportActionBar().setTitle(title);
    }


    public void popFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}
