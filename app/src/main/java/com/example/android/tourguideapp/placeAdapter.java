package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sabina on 6/12/2017.
 */

public class placeAdapter extends ArrayAdapter<Place> {

    private int mColorResourceId;

    public placeAdapter(Context context, ArrayList<Place> places, int coloResourceId) {
        super(context, 0, places);
        mColorResourceId = coloResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.name);
        titleTextView.setText(currentPlace.getName());

        TextView subtitleTextVIew = (TextView) listItemView.findViewById(R.id.description);
        subtitleTextVIew.setText(currentPlace.getDescription());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentPlace.getmImageResourceId());
        imageView.setVisibility(View.VISIBLE);

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
