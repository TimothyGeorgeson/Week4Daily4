package com.example.consultants.week4daily4.ui.main;

import com.example.consultants.week4daily4.model.DSGResponse.Venue;
import com.example.consultants.week4daily4.ui.base.BasePresenter;
import com.example.consultants.week4daily4.ui.base.BaseView;

import java.util.List;

public interface MainContract {
    interface View extends BaseView {

        void onVenues(List<Venue> venueList);
    }

    interface Presenter extends BasePresenter<View> {

        void getVenues();
    }
}
