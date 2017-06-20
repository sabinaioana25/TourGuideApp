package com.example.android.tourguideapp;

/**
 * Created by Sabina on 6/12/2017.
 */

public class Place {
    private String mName;
    private String mDescription;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Place(String name, String description, int imageResourceId) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
