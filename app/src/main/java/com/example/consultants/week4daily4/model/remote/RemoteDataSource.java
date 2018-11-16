package com.example.consultants.week4daily4.model.remote;

import com.example.consultants.week4daily4.NetworkHelper;
import com.example.consultants.week4daily4.model.DSGResponse.DSGResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance() {

        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
//                use for converting the response using Gson
                .addConverterFactory(GsonConverterFactory.create())
                //using rxjava adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private  RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }

    //use call object
//    public Call<DSGResponse> getRandomUser(String gender, int results) {
//
//        return getRemoteService().getVenue(gender, results);
//    }

    //using rxjava
    public Observable<DSGResponse> getVenueObs() {
        return getRemoteService().getVenueObs();
    }
}
