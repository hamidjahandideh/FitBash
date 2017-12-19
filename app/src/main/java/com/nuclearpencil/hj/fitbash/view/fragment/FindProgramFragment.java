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
import com.nuclearpencil.hj.fitbash.web.ge_WC;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.view.adapter.ProgramAdapter;

import com.nuclearpencil.hj.fitbash.view.adapter.ProgramListViewAdapter;
import com.nuclearpencil.hj.fitbash.web.api.ServiceApi;
import com.nuclearpencil.hj.fitbash.web.api.ServiceResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FindProgramFragment extends Fragment {

    final ArrayList<ProgramModel> programModels=new ArrayList<>();
    InternetViewer internetViewer;

    public FindProgramFragment() {
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
        final View rootview = inflater.inflate(R.layout.fragment_find_program, container, false);



        //todo: region temp
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        programModels.add(new ProgramModel(1,"aaa"));
        //endregion


        ProgramListViewAdapter programListViewAdapter=new ProgramListViewAdapter(getContext(),programModels);
        ProgramAdapter adapter = new ProgramAdapter(getActivity(), programModels);
        internetViewer = new InternetViewer(getActivity(), (ViewGroup) rootview.findViewById(R.id.llList), ListModel.RecyclerView, adapter, 5, new LoadItems() {
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
                recyclerView.getRecycledViewPool().setMaxRecycledViews(0,0);//for prevent header item of recycling
            }

            @Override
            public void setListViewSettings(ListView listView) {

            }
        }.setBackgroundResource(R.drawable.ah_bg);

        internetViewer.startLoadItems();


        return rootview;

    }






    private void getItems(final int page) {

//        setLoading more to internetUtil;[ layout manager , rv ]

        internetViewer.setLoading(true);
        ServiceApi categoryItemsApi = ge_WC.retrofitJSON.create(ServiceApi.class);
        final Call<ServiceResponse<ArrayList<ProgramModel>>> call = categoryItemsApi.getList(page);
        call.enqueue(new Callback<ServiceResponse<ArrayList<ProgramModel>>>() {
            @Override
            public void onResponse(Call<ServiceResponse<ArrayList<ProgramModel>>> call, Response<ServiceResponse<ArrayList<ProgramModel>>> response) {

                internetViewer.setLoading(false);
                if (response.body() != null) {
                    ServiceResponse<ArrayList<ProgramModel>> response1 = response.body();
                    final ArrayList<ProgramModel> programModels = response1.getData();

                    if (internetViewer.getListModel()==ListModel.RecyclerView){
                        ProgramListViewAdapter adapter = (ProgramListViewAdapter) internetViewer.getAdapter();
                        adapter.addItems(programModels);
                    }else if (internetViewer.getListModel()==ListModel.RecyclerView){
                        ProgramAdapter adapter = (ProgramAdapter) internetViewer.getAdapter();
                        adapter.addItems(programModels);
                    }

                } else {
                    onFailure(call, new ResponseNullException("response body is null"));
                }

            }


            @Override
            public void onFailure(Call<ServiceResponse<ArrayList<ProgramModel>>> call, Throwable t) {

                internetViewer.showTryAgainSnack(t);
                internetViewer.showTryAgainToast(t);


                if (page==1){
//                    internetViewer.showTryAgain(t);
                }else {
//                    internetViewer.showTryAgainToast(t);
                }


//                internetViewer.hideInternetView(View.GONE);//or View.INVISIBLE

            }

        });

    }






}
