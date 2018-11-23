package com.antoniosj.cleanmvp.deps;

import com.antoniosj.cleanmvp.home.HomeActivity;
import com.antoniosj.cleanmvp.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(HomeActivity homeActivity);
}