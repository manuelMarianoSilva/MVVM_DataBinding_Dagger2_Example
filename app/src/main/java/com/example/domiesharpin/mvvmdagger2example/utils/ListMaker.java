package com.example.domiesharpin.mvvmdagger2example.utils;

import android.app.Activity;
import android.content.Context;

import com.example.domiesharpin.mvvmdagger2example.R;
import com.example.domiesharpin.mvvmdagger2example.remote.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMaker {

    public static List<User> setUserList(Context context) {
        List<String> names = Arrays.asList(context.getResources().getStringArray(R.array.names));
        List<String> emails = Arrays.asList(context.getResources().getStringArray(R.array.emails));
        int imageId = R.drawable.cacho_pic;

        List<User> userList = new ArrayList<>();
        int count = 0;

        for (String name : names) {

            userList.add(new User(name, emails.get(count), imageId));
            count++;

        }

        return userList;
    }
}
