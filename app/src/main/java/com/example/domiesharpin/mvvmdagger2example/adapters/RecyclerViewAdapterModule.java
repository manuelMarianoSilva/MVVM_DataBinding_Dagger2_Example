package com.example.domiesharpin.mvvmdagger2example.adapters;

import dagger.Module;
import dagger.Provides;

@Module
public class RecyclerViewAdapterModule {

    @Provides
    public RecyclerViewAdapter recyclerViewAdapter(){
        return new RecyclerViewAdapter();
    }

}
