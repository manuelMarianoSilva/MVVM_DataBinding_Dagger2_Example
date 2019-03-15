package com.example.domiesharpin.mvvmdagger2example.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.domiesharpin.mvvmdagger2example.R;
import com.example.domiesharpin.mvvmdagger2example.adapters.RecyclerViewAdapter;
import com.example.domiesharpin.mvvmdagger2example.databinding.ActivityRecyclerViewBinding;
import com.example.domiesharpin.mvvmdagger2example.remote.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemViewHolderInterface {

    private ActivityRecyclerViewBinding binding;
    private RecyclerViewAdapter adapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setHasFixedSize(true);


        adapter = new RecyclerViewAdapter(this, setUserListUp(), this);
        binding.recyclerView.setAdapter(adapter);

    }




    private List<User> setUserListUp(){

        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> emails = Arrays.asList(getResources().getStringArray(R.array.emails));
        int imageId = R.drawable.cacho_pic;

        List<User> userList = new ArrayList<>();
        int count = 0;

        for (String name : names) {

            userList.add(new User(name, emails.get(count), imageId));
            count++;

        }

        return userList;
    }


    @Override
    public void onItemClicked(int adapterPosition) {
        Toast.makeText(this, setUserListUp().get(adapterPosition).name, Toast.LENGTH_SHORT).show();
    }
}
