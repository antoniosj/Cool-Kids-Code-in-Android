package com.antoniosj.daggerexample.modules;

import com.antoniosj.daggerexample.presenter.ILoginPresenter;
import com.antoniosj.daggerexample.presenter.ILoginRepository;
import com.antoniosj.daggerexample.presenter.LoginPresenter;
import com.antoniosj.daggerexample.presenter.LoginRepository;


import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {


    @Provides
    public ILoginPresenter providePresenter(ILoginRepository repository) {
        return new LoginPresenter(repository);
    }

    @Provides
    public ILoginRepository provideRepository() {
        return new LoginRepository();
    }

}
