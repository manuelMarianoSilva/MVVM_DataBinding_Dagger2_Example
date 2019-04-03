package com.example.domiesharpin.mvvmdagger2example.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domiesharpin.mvvmdagger2example.R;
import com.example.domiesharpin.mvvmdagger2example.databinding.ItemLayoutBinding;
import com.example.domiesharpin.mvvmdagger2example.remote.model.User;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {

    private List<User> userList;
    private ItemViewHolderInterface itemViewHolderInterface;

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

    public void setItemViewHolderInterface(ItemViewHolderInterface itemViewHolderInterface) {
        this.itemViewHolderInterface = itemViewHolderInterface;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding layoutBinding;
        ItemViewHolderInterface itemViewHolderInterface;

        MyViewHolder(@NonNull ItemLayoutBinding binding) {
            super(binding.getRoot());

            this.layoutBinding = binding;

            layoutBinding.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemViewHolderInterface.onItemClicked(getAdapterPosition());
                }
            });
        }
    }
}
