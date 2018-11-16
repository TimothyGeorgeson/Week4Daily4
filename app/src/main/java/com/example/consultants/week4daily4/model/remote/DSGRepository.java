package com.example.consultants.week4daily4.model.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DSGRepository {

    RemoteDataSource remoteDataSource;

    public DSGRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getVenues(final DSGCallback callback) {

        remoteDataSource.getVenueObs()
//                    make the network call on the worker thread
                .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserver(callback));


    }
}
