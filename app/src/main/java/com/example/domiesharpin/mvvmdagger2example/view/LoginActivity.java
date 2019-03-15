package com.example.domiesharpin.mvvmdagger2example.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.domiesharpin.mvvmdagger2example.R;
import com.example.domiesharpin.mvvmdagger2example.base.MyApplication;
import com.example.domiesharpin.mvvmdagger2example.databinding.ActivityLoginBinding;
import com.example.domiesharpin.mvvmdagger2example.viewModel.LoginViewModel;
import com.example.domiesharpin.mvvmdagger2example.viewModelFactories.ViewModelFactory;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent(getApplicationContext()).inject(this);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        LoginViewModel loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);

        binding.setLoginviewmodel(loginViewModel);
        binding.setLifecycleOwner(this);
    }
}
