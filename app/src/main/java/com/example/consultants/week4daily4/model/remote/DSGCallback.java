package com.example.consultants.week4daily4.model.remote;

import com.example.consultants.week4daily4.model.DSGResponse.DSGResponse;
import com.example.consultants.week4daily4.model.DSGResponse.Venue;

import java.util.List;

public interface DSGCallback {

    void onSuccess(List<Venue> venueList);

    void onFailure(String error);
}
