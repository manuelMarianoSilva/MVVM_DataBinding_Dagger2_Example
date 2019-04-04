package com.example.domiesharpin.mvvmdagger2example.viewModel;


import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;

import com.example.domiesharpin.mvvmdagger2example.adapters.RecyclerViewAdapter;
import com.example.domiesharpin.mvvmdagger2example.remote.model.User;
import com.example.domiesharpin.mvvmdagger2example.utils.ListMaker;

import java.util.List;

public class RecyclerViewActivityViewModel extends ViewModel {

    private List<User> userList;
    private RecyclerViewAdapter recyclerViewAdapter;

    public RecyclerViewActivityViewModel(Context context) {
        this.userList = ListMaker.setUserList(context);
        this.recyclerViewAdapter = new RecyclerViewAdapter();
    }

    public List<User> getUserList() {
        return userList;
    }

    public RecyclerViewAdapter getRecyclerViewAdapter() {
        return recyclerViewAdapter;
    }
}
