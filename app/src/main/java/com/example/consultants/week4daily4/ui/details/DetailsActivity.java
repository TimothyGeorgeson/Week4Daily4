package com.example.consultants.week4daily4.ui.details;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consultants.week4daily4.R;

import java.io.InputStream;

public class DetailsActivity extends AppCompatActivity {

    ImageView imgStar;
    ImageView imgPhoto;
    TextView tvDetName;
    TextView tvDetCity;
    TextView tvDetState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgStar = findViewById(R.id.imgStar);
        imgPhoto = findViewById(R.id.imgPhoto);
        tvDetName = findViewById(R.id.tvDetName);
        tvDetCity = findViewById(R.id.tvDetCity);
        tvDetState = findViewById(R.id.tvDetState);

        tvDetName.setText(getIntent().getExtras().getString("name"));
        tvDetCity.setText(getIntent().getExtras().getString("city"));
        tvDetState.setText(getIntent().getExtras().getString("state"));

        String photoURL = getIntent().getExtras().getString("photo");
        if (photoURL.equals("") == false)
        {
            Bitmap bmImage = null;
            try {
                InputStream in = new java.net.URL(photoURL).openStream();
                bmImage = BitmapFactory.decodeStream(in);
                imgPhoto.setImageBitmap(bmImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void makeFavorite(View view) {
        imgStar.setVisibility(View.VISIBLE);
    }
}
