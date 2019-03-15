package com.example.domiesharpin.mvvmdagger2example.viewModelFactories;

import android.arch.lifecycle.ViewModel;

import com.example.domiesharpin.mvvmdagger2example.viewModel.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindsLoginViewModel(LoginViewModel loginViewModel);

}
