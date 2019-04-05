package com.example.domiesharpin.mvvmdagger2example.remote;

import android.arch.lifecycle.MutableLiveData;

public class LoginRepository {

    private MutableLiveData<String> data = new MutableLiveData<>();

    public MutableLiveData<String> getData(String user, String password){
        data.setValue((user.trim().equals("Cacho")) ? "Success" : "Error");
        return data;
    }

    public MutableLiveData<String> getEmptyData(){
        return data;
    }

    public MutableLiveData<String> setPasswordToResponse(String password) {
        data.setValue(password);
        return data;
    }
}
