package com.example.android.tourguideapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sabina on 6/17/2017.
 */

public class PlaceDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set custom font to TextViews inside activity_place_detail
        String fontPath = "fonts/PatrickHandSC_Regular.ttf";
        TextView titleView = (TextView) findViewById(R.id.title_large);
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        TextView addressView = (TextView) findViewById(R.id.address_large);
        TextView descripView = (TextView) findViewById(R.id.description_large);
        titleView.setTypeface(tf);
        addressView.setTypeface(tf);
        descripView.setTypeface(tf);

        //Get extras from the intent in the MainActivity, using the 'keys' provided
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(getString(R.string.key_name));
        String address = bundle.getString(getString(R.string.key_address));
        int image = bundle.getInt(getString(R.string.key_image));
        String description = bundle.getString("description");
        final String website = bundle.getString("website");

        //Set the corresponding TextView and ImageViews in the detail layout
        //depending on what is clicked;
        //The views are populated by choosing the position from the String-array
        ImageView detailImage = (ImageView) findViewById(R.id.large_image);
        detailImage.setImageResource(image);

//        TextView detailTitle = (TextView) findViewById(R.id.title_large);
        titleView.setText(name);

//        TextView detailAddress = (TextView) findViewById(R.id.address_large);
        addressView.setText(address);

//        TextView detailDescription = (TextView) findViewById(R.id.description_large);
        descripView.setText(description);

        //Intent for opening a browser app and navigating to the website;
        //Intent corresponds  to the 'link' ImageView in activity_place_detail
        ImageView goToWebsite = (ImageView) findViewById(R.id.go_to_website);
        goToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intentWebsite);
            }
        });

        //Intent for opening an email app and sending the details of the place to someone;
        //Intent corresponds  to the 'share arrow' ImageView in activity_place_detail
        ImageView shareEmail = (ImageView) findViewById(R.id.share);
        shareEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SENDTO);
                intentShare.setData(Uri.parse(getString(R.string.email_data)));
                intentShare.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                startActivity(intentShare);
            }
        });
    }
}

