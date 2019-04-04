package com.example.domiesharpin.mvvmdagger2example.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.domiesharpin.mvvmdagger2example.remote.LoginRepository;

import javax.inject.Inject;


public class LoginViewModel extends ViewModel {

    public ObservableField<String> usernameFieldBoundToXML = new ObservableField<>("");
    public ObservableField<String> passwordFieldBoundToXML = new ObservableField<>("");
    private MutableLiveData<String> response;
    public LoginViewModelInterface loginViewModelInterface;

    private LoginRepository loginRepository;

    @Inject
    public LoginViewModel(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
        response = loginRepository.getEmptyData();
    }

    public void login(){
        response = loginRepository.getData(
                usernameFieldBoundToXML.get(),
                passwordFieldBoundToXML.get()
        );
    }

    public void showPassword(){
        response = loginRepository.setPasswordToResponse(passwordFieldBoundToXML.get());
    }

    public LiveData<String> getResponse() {
        return response;
    }

    public void goToRecyclerActivity(){
        loginViewModelInterface.goToRecyclerActivity();
    }

    public interface LoginViewModelInterface{
        void goToRecyclerActivity();
    }
}
