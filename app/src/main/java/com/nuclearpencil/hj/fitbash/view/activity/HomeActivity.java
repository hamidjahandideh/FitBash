package com.nuclearpencil.hj.fitbash.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.flipboard.bottomsheet.BottomSheetLayout;

import com.flipboard.bottomsheet.commons.MenuSheetView;
import com.hj.calendar.interfaces.calendarListener;
import com.hj.calendar.model.CalendarModel;
import com.hj.calendar.view.ProgressWheel;
import com.nuclearpencil.hj.fitbash.app.App;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutModel;
import com.nuclearpencil.hj.fitbash.R;
import com.hj.calendar.CalendarFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.DrawerFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.AdvisorFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.GymFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.MusicFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.LearnExerciseFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.MySizesFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.EditProfileFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.ProgramFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.StoreFragment;
import com.nuclearpencil.hj.fitbash.view.fragment.WorkoutFragment;

import java.util.ArrayList;
import java.util.Stack;


public class HomeActivity extends BaseActivity {


    ArrayList<WorkoutModel> list;
    int year = 1500;
    int month = 8;
    int day = 9;

    boolean bReadyToExit=false;
    BottomSheetLayout bottomSheetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (App.userUtil.isLogged()){
            setContentView(R.layout.activity_home);
            setNavigation();
            list=new ArrayList<WorkoutModel>();
            list.add(new WorkoutModel(3));
            list.add(new WorkoutModel(5));
            list.add(new WorkoutModel(8));
            list.add(new WorkoutModel(1));
            pushFragment(new EditProfileFragment());
        }else {
            startActivity(new Intent(this,RegisterLoginActivity.class));
            finish();
        }


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        bottomSheetLayout.dismissSheet();
    }


    private void setNavigation() {

        ImageView ivLearnExercise = (ImageView) findViewById(R.id.ivLearnExercise);
        ImageView ivMyMusic = (ImageView) findViewById(R.id.ivMyMusic);
        ImageView ivProfile = (ImageView) findViewById(R.id.ivProfile);
        ImageView ivTodayWorkout = (ImageView) findViewById(R.id.ivTodayWorkout);
        ImageView ivCategory = (ImageView) findViewById(R.id.ivCategory);

        ivLearnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                pushFragment(new LearnExerciseFragment());
            }
        });


        ivLearnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                pushFragment(new MusicFragment());
            }
        });


        ivMyMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                pushFragment(new AdvisorFragment());
            }
        });


        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomSheetLayout);
        ivCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(bottomSheetLayout,R.menu.menu_buttomsheet_categories);
            }
        });

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(bottomSheetLayout, R.menu.menu_buttomsheet_profile);
            }
        });

    }


    private void showBottomSheet(final BottomSheetLayout bottomSheet, int menuRes) {


        MenuSheetView menuSheetView = new MenuSheetView(getBaseContext(), com.flipboard.bottomsheet.commons.MenuSheetView.MenuType.GRID, null, new MenuSheetView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mMyCalendar:

                        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                        final CalendarFragment fragment=new CalendarFragment();
                        fragment.affectItemsToCalendar(list,year,month,day)
                                .setCalendarListener(new calendarListener() {
                                        @Override
                                        public void onDayClick(CalendarModel calendarModel) {
                                            WorkoutModel c = (WorkoutModel) calendarModel.getObject();
                                            pushFragment(new WorkoutFragment());
                                        }

                                        @Override
                                        public void onChangeDate(int year, int month, ProgressWheel progressWheel) {
                                            progressWheel.setVisibility(View.VISIBLE);
                                            fragment.ClearEvents();
                                            HomeActivity.this.year=year;
                                            HomeActivity.this.month=month;
                                            fragment.affectItemsToCalendar(list,year,month,day);
                                        }
                                    });
                        pushFragment(fragment);


                        break;
                    case R.id.mMyMusic:
                         break;
                    case R.id.mMyGallery:
                         break;
                    case R.id.mMySizes:
                        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                        pushFragment(new MySizesFragment());
                        break;
                    case R.id.mStore:
                        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                        pushFragment(new StoreFragment());
                        break;
                    case R.id.mGym:
                        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                        pushFragment(new GymFragment());
                        break;
                    case R.id.mProgram:
                        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear all fragments
                        pushFragment(new ProgramFragment());
                        break;
                    case R.id.mTrainer:
                         break;

                }
                if (bottomSheet.isSheetShowing()) {
                    bottomSheet.dismissSheet();
                }
                return false;
            }
        });


        bottomSheet.setPeekOnDismiss(true);
//        menuSheetView.offsetTopAndBottom(70);
        menuSheetView.inflateMenu(menuRes);
        LinearLayout linearLayout = (LinearLayout) menuSheetView.getChildAt(0);
//        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,700);
//        linearLayout.setLayoutParams(layoutParams);
        bottomSheet.showWithSheetView(menuSheetView);



    }






    @Override
    public void onBackPressed() {

        DrawerFragment drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.f_drawer);
        if (drawerFragment!=null && drawerFragment.getDrawer().isDrawerOpen())
            drawerFragment.getDrawer().closeDrawer();
        else {
            if (fragmentManager.getBackStackEntryCount()>1)
                fragmentManager.popBackStack();
            else{
                if(bReadyToExit) {
                    fragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    super.onBackPressed();
                }
                bReadyToExit=true;
                Toast.makeText(this,"برای خروج دوباره بزنید", Toast.LENGTH_SHORT).show();

                new Thread(new Runnable() {
                    public void run() {
                        SystemClock.sleep(2000);
                        bReadyToExit=false;
                    }
                }).start();
            }
        }


    }









}
