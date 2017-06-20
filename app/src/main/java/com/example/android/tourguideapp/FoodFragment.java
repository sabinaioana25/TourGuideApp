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

public class FoodFragment extends Fragment {
    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        final int[] imageFood = {R.drawable.union_pubjpg, R.drawable.royal_teas, R.drawable.jamies_italian_greenwich, R.drawable.zero_degrees,
                R.drawable.stick_n_sushi, R.drawable.franco_manca, R.drawable.bibimpbap};
        final String[] foodName = getResources().getStringArray(R.array.food_name);
        final String[] foodAddress = getResources().getStringArray(R.array.food_address);
        final String[] foodDescription = getResources().getStringArray(R.array.food_description);
        final String[] foodWebsite = getResources().getStringArray(R.array.food_website);

        final ArrayList<Place> places = new ArrayList<Place>();

        //Using an 'if' statement to go through each item each list.
        for (int i = 0; i <= 6; i++) {
            places.add(new Place(foodName[i], foodAddress[i], imageFood[i]));
        }

        final placeAdapter adapter = new placeAdapter(getActivity(), places, R.color.primary_light);
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        placesListView.setAdapter(adapter);

        //Intent to bring up a detail screen of the item that is clicked.
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
                intent.putExtra("name", foodName[position]);
                intent.putExtra("address", foodAddress[position]);
                intent.putExtra("description", foodDescription[position]);
                intent.putExtra("website", foodWebsite[position]);
                intent.putExtra("image", imageFood[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
}