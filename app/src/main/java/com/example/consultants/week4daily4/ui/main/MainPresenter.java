package com.example.consultants.week4daily4.ui.main;

import android.util.Log;

import com.example.consultants.week4daily4.model.DSGResponse.Venue;
import com.example.consultants.week4daily4.model.remote.DSGCallback;
import com.example.consultants.week4daily4.model.remote.DSGRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter{
    public static final String TAG = MainPresenter.class.getSimpleName() + "_TAG";

    MainContract.View view;
    DSGRepository repository;

    public MainPresenter(DSGRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getVenues() {

        repository.getVenues(new DSGCallback() {
            @Override
            public void onSuccess(List<Venue> venueList) {
                Log.d(TAG, "onSuccess: " + venueList.size());
                view.onVenues(venueList);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);

            }
        });

    }


    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

}
