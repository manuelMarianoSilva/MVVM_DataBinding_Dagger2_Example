package com.example.domiesharpin.mvvmdagger2example.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.domiesharpin.mvvmdagger2example.R;
import com.example.domiesharpin.mvvmdagger2example.databinding.ItemLayoutBinding;
import com.example.domiesharpin.mvvmdagger2example.remote.model.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {

    private Context context;
    private List<User> userList = new ArrayList<>();
    private ItemViewHolderInterface itemViewHolderInterface;

    public RecyclerViewAdapter(Context context, List<User> userList, ItemViewHolderInterface itemViewHolderInterface) {
        this.context = context;
        this.userList = userList;
        this.itemViewHolderInterface = itemViewHolderInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.item_layout,
                viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(binding);
        myViewHolder.itemViewHolderInterface = itemViewHolderInterface;
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        User user = userList.get(i);
        myViewHolder.layoutBinding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface ItemViewHolderInterface{
        void onItemClicked(int adapterPosition);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding layoutBinding;
        ItemViewHolderInterface itemViewHolderInterface;


        public MyViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());

            layoutBinding = itemView;



            layoutBinding.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemViewHolderInterface.onItemClicked(getAdapterPosition());
                }
            });
        }


    }

}
