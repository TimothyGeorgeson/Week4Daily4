package com.example.consultants.week4daily4.model.remote;

import com.example.consultants.week4daily4.model.DSGResponse.DSGResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

    //    using the rxjava observable
    @GET("venue/")
    Observable<DSGResponse> getVenueObs();
}
