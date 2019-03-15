package com.example.domiesharpin.mvvmdagger2example.remote;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class LoginRepositoryModule {

    @Provides
    static LoginRepository providesLoginRepository(){
        return new LoginRepository();
    }
}
