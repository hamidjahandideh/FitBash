package com.nuclearpencil.hj.fitbash.view.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.ExerciseModel;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutModel;
import com.nuclearpencil.hj.fitbash.view.adapter.WorkoutAdapter;
import com.nuclearpencil.hj.fitbash.view.interfaces.ExcerciseItemClickListener;

import java.util.ArrayList;


public class WorkoutFragment extends Fragment {


    BottomSheetLayout bottomSheetLayout;
    public WorkoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //String strtext = getArguments().getString("edttext");
        View rootview = inflater.inflate(R.layout.fragment_workout, container, false);
        RecyclerView recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);
        bottomSheetLayout = (BottomSheetLayout) rootview.findViewById(R.id.bottomSheetLayout);



        ArrayList<ExerciseModel> exerciseModels=new ArrayList<>();
        exerciseModels.add(new ExerciseModel(1,"hghgjhg","","","","","","","",""));
        exerciseModels.add(new ExerciseModel(2,"iuytiut","","","","","","","",""));
        exerciseModels.add(new ExerciseModel(3,"","","","","","","","",""));
        exerciseModels.add(new ExerciseModel(4,"","","","","","","","",""));
        WorkoutModel workoutModel=new WorkoutModel(9,1,"","","","","","","","","","","","",exerciseModels);


        ExcerciseItemClickListener excerciseItemClickListener =new ExcerciseItemClickListener() {
            @Override
            public void onClick(ExerciseModel exerciseModel) {
                showBottomSheet(exerciseModel);
            }
        };
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        WorkoutAdapter adapter=new WorkoutAdapter(getContext(),workoutModel, excerciseItemClickListener);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




//        startActivity(new Intent(getContext(), NewWorkoutActivity.class));


        return rootview;

    }



    public void showBottomSheet(ExerciseModel exerciseModel) {


        View rootview = LayoutInflater.from(getContext()).inflate(R.layout.activity_excercise_guide, bottomSheetLayout, false);
        TextView tvDescription=rootview.findViewById(R.id.tvDescription);
        tvDescription.setText(exerciseModel.getDescribtion());

        bottomSheetLayout.showWithSheetView(rootview);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomSheetLayout.expandSheet();
            }
        },50);

/*
        bottomSheet.showWithSheetView(new IntentPickerSheetView(HomeActivity.this, new Intent(HomeActivity.this,HelpActivity.class), "Share with...", new IntentPickerSheetView.OnIntentPickedListener() {
                @Override
                public void onIntentPicked(IntentPickerSheetView.ActivityInfo activityInfo) {
                    bottomSheet.dismissSheet();
                    startActivity(activityInfo.getConcreteIntent(new Intent(HomeActivity.this,DirectionActivity.class)));
                }
            }));
*/



/*

        MenuSheetView menuSheetView = new MenuSheetView(this, MenuSheetView.MenuType.GRID, "منو . . .", new MenuSheetView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (bottomSheet.isSheetShowing()) {
                    bottomSheet.dismissSheet();
                }
                switch (item.getItemId()){
                    case R.id.m_toolbox:
                        startActivity(new Intent(getBaseContext(), ToolboxActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.m_carstate:
                        startActivity(new Intent(getBaseContext(), CarStateActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.m_simcard:
                        startActivity(new Intent(getBaseContext(), SimCardActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.m_direction:

                        if (ge_C.RunInTestMode || ActiveAppUtils.getAppActiveLevel(HomeActivity.this)>=ActiveAppUtils.SilverValue) {
                            startActivity(new Intent(getBaseContext(), DirectionActivity.class));
                            overridePendingTransition(0, 0);
                        }else {
                            ToastUtil.ShowToast(getBaseContext(),ActiveAppUtils.getAppNeedActiveString(HomeActivity.this,"مسیر یابی"));
                        }
                        break;


                }

                return true;
            }
        });
        menuSheetView.inflateMenu(R.menu.menu_buttomsheet);
        bottomSheet.showWithSheetView(menuSheetView);

*/





/*

            IntentPickerSheetView intentPickerSheet = new IntentPickerSheetView(this, shareIntent, "Share with...", new IntentPickerSheetView.OnIntentPickedListener() {
                @Override
                public void onIntentPicked(IntentPickerSheetView.ActivityInfo activityInfo) {
                    bottomSheet.dismissSheet();
                    startActivity(activityInfo.getConcreteIntent(shareIntent));
                }
            });


// Filter out built in sharing options such as bluetooth and beam.
            intentPickerSheet.setFilter(new IntentPickerSheetView.Filter() {
                @Override
                public boolean include(IntentPickerSheetView.ActivityInfo info) {
                    return !info.componentName.getPackageName().startsWith("com.android");
                }
            });
// Sort activities in reverse order for no good reason
            intentPickerSheet.setSortMethod(new Comparator<IntentPickerSheetView.ActivityInfo>() {
                @Override
                public int compare(IntentPickerSheetView.ActivityInfo lhs, IntentPickerSheetView.ActivityInfo rhs) {
                    return rhs.label.compareTo(lhs.label);
                }
            });
            bottomSheet.showWithSheetView(intentPickerSheet);
*/








    }







}
