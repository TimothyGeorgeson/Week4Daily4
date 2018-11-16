
package com.example.consultants.week4daily4.model.DSGResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DSGResponse {

    @SerializedName("venues")
    @Expose
    private List<Venue> venues = null;

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

}
