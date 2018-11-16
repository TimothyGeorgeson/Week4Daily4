package com.example.consultants.week4daily4.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.consultants.week4daily4.R;
import com.example.consultants.week4daily4.model.DSGResponse.Venue;
import com.example.consultants.week4daily4.model.remote.DSGRepository;
import com.example.consultants.week4daily4.model.remote.RemoteDataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new DSGRepository(new RemoteDataSource()));
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

    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
