package com.nuclearpencil.hj.fitbash.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hj.internetviewer.InternetViewer;
import com.hj.internetviewer.enums.ListModel;
import com.hj.internetviewer.interfaces.LoadItems;
import com.hj.internetviewer.model.ResponseNullException;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.view.adapter.ProgramDetailsAdapter;
import com.nuclearpencil.hj.fitbash.web.ge_WC;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.data.model.WorkoutWeekModel;
import com.nuclearpencil.hj.fitbash.web.api.ServiceApi;
import com.nuclearpencil.hj.fitbash.web.api.ServiceResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProgramDetailsFragment extends Fragment {

    InternetViewer internetViewer;

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

        ProgramDetailsAdapter adapter = new ProgramDetailsAdapter(getActivity(), workoutWeekModels);
        internetViewer = new InternetViewer(getContext(), (ViewGroup) rootview.findViewById(R.id.llList), ListModel.RecyclerView, adapter, 5, new LoadItems() {
            @Override
            public void onLoad(int page) {
                getItems(page);
            }
        }) {
            @Override
            public void setRecyclerViewSettings(RecyclerView recyclerView) {

                recyclerView.setNestedScrollingEnabled(false);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                //layoutManager.setAutoMeasureEnabled(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);

            }

            @Override
            public void setListViewSettings(ListView listView) {

            }
        };
        internetViewer.startLoadItems();




        return rootview;

    }




    private void getItems(final int page) {

        internetViewer.setLoading(true);
        ServiceApi categoryItemsApi = ge_WC.retrofitJSON.create(ServiceApi.class);
        final Call<ServiceResponse<ArrayList<ProgramModel>>> call = categoryItemsApi.getList(page);
        call.enqueue(new Callback<ServiceResponse<ArrayList<ProgramModel>>>() {
            @Override
            public void onResponse(Call<ServiceResponse<ArrayList<ProgramModel>>> call, Response<ServiceResponse<ArrayList<ProgramModel>>> response) {

                internetViewer.setLoading(false);
                if (response.body() != null) {
                    ServiceResponse<ArrayList<ProgramModel>> response1 = response.body();
                    final ArrayList<ProgramModel> videos = response1.getData();

/*                    ProgramDetailsAdapter adapter = (ProgramDetailsAdapter) internet.getAdapter();
                    adapter.addItems(videos);*/

                } else {
                    onFailure(call, new ResponseNullException("response body is null"));
                }

            }


            @Override
            public void onFailure(Call<ServiceResponse<ArrayList<ProgramModel>>> call, Throwable t) {

//                internetViewer.showTryAgainView(t);
//                internetViewer.showTryAgainSnack(t);
//                internetViewer.showTryAgainToast(t);

                if (page==1){
//                    internetViewer.showTryAgain(t);
                }else {
//                    internetViewer.showTryAgainToast(t);
                }
//              internetViewer.hideInternetView(View.GONE);//or View.INVISIBLE

            }

        });

    }





}
