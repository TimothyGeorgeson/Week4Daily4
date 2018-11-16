package com.example.consultants.week4daily4.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.consultants.week4daily4.R;
import com.example.consultants.week4daily4.di.DaggerMainComponent;
import com.example.consultants.week4daily4.model.DSGResponse.Venue;
import com.example.consultants.week4daily4.model.remote.DSGRepository;
import com.example.consultants.week4daily4.model.remote.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    RecyclerView rvVenueList;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.create().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }

    public void onShowVenues(View view) {
        presenter.getVenues();
    }

    @Override
    public void onVenues(List<Venue> venueList) {
        adapter = new RecyclerViewAdapter(venueList);
        layoutManager = new LinearLayoutManager(this);
        rvVenueList = findViewById(R.id.rvVenueList);
        rvVenueList.setAdapter(adapter);
        rvVenueList.setLayoutManager(layoutManager);
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
