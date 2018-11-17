package com.example.consultants.week4daily4.ui.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4daily4.R;
import com.example.consultants.week4daily4.model.DSGResponse.Venue;
import com.example.consultants.week4daily4.ui.details.DetailsActivity;

import java.io.InputStream;
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
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        final Venue venue = venueList.get(i);

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

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlPicture = "";
                if(venue.getPhotos().size() > 0) {
                    urlPicture = venue.getPhotos().get(0).getUrl();
                }

                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("name", viewHolder.tvName.getText());
                intent.putExtra("city", viewHolder.tvCity.getText());
                intent.putExtra("state", viewHolder.tvState.getText());
                intent.putExtra("photo", urlPicture);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
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
