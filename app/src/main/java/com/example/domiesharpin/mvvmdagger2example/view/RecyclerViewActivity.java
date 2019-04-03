package com.example.domiesharpin.mvvmdagger2example.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.domiesharpin.mvvmdagger2example.R;
import com.example.domiesharpin.mvvmdagger2example.adapters.RecyclerViewAdapter;
import com.example.domiesharpin.mvvmdagger2example.base.MyApplication;
import com.example.domiesharpin.mvvmdagger2example.databinding.ActivityRecyclerViewBinding;
import com.example.domiesharpin.mvvmdagger2example.remote.model.User;
import com.example.domiesharpin.mvvmdagger2example.utils.ListMaker;

import java.util.List;

import javax.inject.Inject;


public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemViewHolderInterface {

    @Inject RecyclerViewAdapter adapter;
    private ActivityRecyclerViewBinding binding;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent(this).inject(this);
        bindView();
        setAdapter();
    }

    private void bindView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
    }

    private void setAdapter() {
        userList = ListMaker.setUserList(this);
        adapter.setUserList(userList);

        adapter.setItemViewHolderInterface(this);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int adapterPosition) {
        Toast.makeText(this, userList.get(adapterPosition).name, Toast.LENGTH_SHORT).show();
    }
}
