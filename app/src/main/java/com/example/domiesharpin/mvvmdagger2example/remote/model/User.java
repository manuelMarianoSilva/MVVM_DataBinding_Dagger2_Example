package com.example.domiesharpin.mvvmdagger2example.remote.model;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class User {

    public String name, email;
    public int imageID;

    public User(String name, String email, int imageID) {
        this.name = name;
        this.email = email;
        this.imageID = imageID;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getImageID() {
        return imageID;
    }


    @BindingAdapter("android:imageUrl")
    public static void loadImage (View view, int imageID){

        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), imageID));
    }
}


