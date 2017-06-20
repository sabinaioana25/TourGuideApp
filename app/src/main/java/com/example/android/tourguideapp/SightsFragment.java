package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SightsFragment extends Fragment {
    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragments
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        final int[] imageSight = {R.drawable.tower_bridge, R.drawable.buckingham_palace, R.drawable.london_eye, R.drawable.tate_modern_2,
                R.drawable.shakespeares_globe, R.drawable.barbican_2};
        final String[] sightName = getResources().getStringArray(R.array.sights_name);
        final String[] sightAddress = getResources().getStringArray(R.array.sights_address);
        final String[] sightDescription = getResources().getStringArray(R.array.sights_description);
        final String[] sightWebsite = getResources().getStringArray(R.array.sights_website);

        final ArrayList<Place> places = new ArrayList<Place>();

        //Using an 'if' statement to go through each item each list.
        for (int i = 0; i <= 5; i++) {
            places.add(new Place(sightName[i], sightAddress[i], imageSight[i]));
        }

        final placeAdapter adapter = new placeAdapter(getActivity(), places, R.color.primary_light);
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        placesListView.setAdapter(adapter);

        //Intent to bring up a detail screen of the item that is clicked.
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
                intent.putExtra("name", sightName[position]);
                intent.putExtra("address", sightAddress[position]);
                intent.putExtra("description", sightDescription[position]);
                intent.putExtra("website", sightWebsite[position]);
                intent.putExtra("image", imageSight[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
}