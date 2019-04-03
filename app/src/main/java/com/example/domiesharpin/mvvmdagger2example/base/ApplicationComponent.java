package com.example.domiesharpin.mvvmdagger2example.base;

import com.example.domiesharpin.mvvmdagger2example.adapters.RecyclerViewAdapterModule;
import com.example.domiesharpin.mvvmdagger2example.remote.LoginRepositoryModule;
import com.example.domiesharpin.mvvmdagger2example.view.LoginActivity;
import com.example.domiesharpin.mvvmdagger2example.view.RecyclerViewActivity;
import com.example.domiesharpin.mvvmdagger2example.viewModelFactories.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ViewModelModule.class,
        LoginRepositoryModule.class,
        RecyclerViewAdapterModule.class
})

public interface ApplicationComponent {

    void inject(LoginActivity loginActivity);

    void inject(RecyclerViewActivity recyclerViewActivity);
}
