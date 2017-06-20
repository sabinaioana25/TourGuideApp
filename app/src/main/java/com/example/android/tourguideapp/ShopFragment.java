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

public class ShopFragment extends Fragment {
    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        final int[] imageShop = {R.drawable.victoria_place, R.drawable.westfield, R.drawable.angel, R.drawable.oxford,
                R.drawable.harrods};
        final String[] shopName = getResources().getStringArray(R.array.shop_name);
        final String[] shopAddress = getResources().getStringArray(R.array.shop_address);
        final String[] shopDescription = getResources().getStringArray(R.array.shop_description);
        final String[] shopWebsite = getResources().getStringArray(R.array.shop_website);

        final ArrayList<Place> places = new ArrayList<>();

        //Using an 'if' statement to go through each item each list.
        for (int i = 0; i <= 4; i++) {
            places.add(new Place(shopName[i], shopAddress[i], imageShop[i]));
        }

        final PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.primary_light);
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        placesListView.setAdapter(adapter);

        //Intent to bring up a detail screen of the item that is clicked.
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
                intent.putExtra(getString(R.string.key_name), shopName[position]);
                intent.putExtra(getString(R.string.key_address), shopAddress[position]);
                intent.putExtra(getString(R.string.key_description), shopDescription[position]);
                intent.putExtra(getString(R.string.key_website), shopWebsite[position]);
                intent.putExtra(getString(R.string.key_image), imageShop[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
}