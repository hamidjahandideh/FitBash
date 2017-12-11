package com.nuclearpencil.hj.fitbash.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hj.internetviewer.InternetViewer;
import com.hj.internetviewer.model.ResponseNullException;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.app.ge_WC;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutWeekModel;
import com.nuclearpencil.hj.fitbash.view.adapter.WorkoutWeekAdapter;
import com.nuclearpencil.hj.fitbash.web.api.ServiceApi;
import com.nuclearpencil.hj.fitbash.web.api.ServiceResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProgramDetailsFragment extends Fragment {

    InternetViewer internet;

    public ProgramDetailsFragment() {
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
        final View rootview = inflater.inflate(R.layout.fragment_program_details, container, false);




        //todo: region temp
        final ArrayList<WorkoutWeekModel> workoutWeekModels=new ArrayList<>();
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));
        workoutWeekModels.add(new WorkoutWeekModel(1));

        //endregion

        WorkoutWeekAdapter adapter = new WorkoutWeekAdapter(getActivity(), workoutWeekModels);
/*
        internet = new InternetViewer(getContext(), (ViewGroup) rootview.findViewById(R.id.llList), R.drawable.ah_bg, ListModel.RecyclerView, adapter,5, new LoadItems() {
            @Override
            public void onFirstLoadItems() {
                getItems(1);
            }

            @Override
            public void onLoad(int page) {
                getItems(page);
            }
        });
*/



        return rootview;

    }




    private void getItems(final int page) {


        internet.setLoading(true);
        ServiceApi categoryItemsApi = ge_WC.retrofitJSON.create(ServiceApi.class);
        final Call<ServiceResponse<ArrayList<ProgramModel>>> call = categoryItemsApi.getList(page);
        call.enqueue(new Callback<ServiceResponse<ArrayList<ProgramModel>>>() {
            @Override
            public void onResponse(Call<ServiceResponse<ArrayList<ProgramModel>>> call, Response<ServiceResponse<ArrayList<ProgramModel>>> response) {

                internet.setLoading(false);
                if (response.body() != null) {
                    ServiceResponse<ArrayList<ProgramModel>> response1 = response.body();
                    final ArrayList<ProgramModel> videos = response1.getData();

/*                    WorkoutWeekAdapter adapter = (WorkoutWeekAdapter) internet.getAdapter();
                    adapter.addItems(videos);*/

                } else {
                    onFailure(call, new ResponseNullException("response body is null"));
                }

            }


            @Override
            public void onFailure(Call<ServiceResponse<ArrayList<ProgramModel>>> call, Throwable t) {

                if (page==1){
                    internet.showTryAgain(t);
                }else {
                    internet.showTryAgainToast(t);
                }
//                internet.hideInternetView(View.GONE);//or View.INVISIBLE


            }

        });

    }





}
