package com.example.consultants.week4daily4.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4daily4.R;
import com.example.consultants.week4daily4.model.DSGResponse.Venue;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Venue> venueList;

    public RecyclerViewAdapter(List<Venue> venueList) {
        this.venueList = venueList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflate view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        Venue venue = venueList.get(i);

        viewHolder.tvName.setText("Name: " + venue.getName());
        //one of the locations was null, so adding check
        if (venue.getLocation() != null) {
            viewHolder.tvCity.setText("City: " + venue.getLocation().getCity());
            viewHolder.tvState.setText("State: " + venue.getLocation().getState());
        } else {
            viewHolder.tvCity.setText("City: ");
            viewHolder.tvState.setText("State: ");
        }

        viewHolder.tvRating.setText("Rating: " + venue.getRating().toString());
    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvCity;
        private final TextView tvState;
        private final TextView tvRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvState = itemView.findViewById(R.id.tvState);
            tvRating = itemView.findViewById(R.id.tvRating);
        }
    }
}
