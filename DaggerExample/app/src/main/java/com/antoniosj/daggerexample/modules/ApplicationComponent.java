package com.antoniosj.daggerexample.modules;

import com.antoniosj.daggerexample.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        LoginModule.class
}
)
public interface ApplicationComponent {
    void inject(MainActivity target);
}
