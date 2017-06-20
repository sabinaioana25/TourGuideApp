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

public class NewsFragment extends Fragment {
    public NewsFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        final int[] imageNew = {R.drawable.luna_cinema, R.drawable.jazz_cafe_camden, R.drawable.silent_disco_cutty_sark, R.drawable.grayson_perry,
                R.drawable.greenwich_fet, R.drawable.tristan_yseult};
        final String[] newName = getResources().getStringArray(R.array.new_name);
        final String[] newAddress = getResources().getStringArray(R.array.new_address);
        final String[] newDescription = getResources().getStringArray(R.array.new_description);
        final String[] newWebsite = getResources().getStringArray(R.array.new_website);

        final ArrayList<Place> places = new ArrayList<Place>();

        //Using an 'if' statement to go through each item each list.
        for (int i = 0; i <= 5; i++) {
            places.add(new Place(newName[i], newAddress[i], imageNew[i]));
        }

        final placeAdapter adapter = new placeAdapter(getActivity(), places, R.color.primary_light);
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        placesListView.setAdapter(adapter);

        //Intent to bring up a detail screen of the item that is clicked.
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
                intent.putExtra("name", newName[position]);
                intent.putExtra("address", newAddress[position]);
                intent.putExtra("description", newDescription[position]);
                intent.putExtra("website", newWebsite[position]);
                intent.putExtra("image", imageNew[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
