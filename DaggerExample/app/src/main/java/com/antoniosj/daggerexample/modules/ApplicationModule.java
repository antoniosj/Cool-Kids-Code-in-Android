package com.antoniosj.daggerexample.modules;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {

        this.context = context;
    }


    @Provides
    @Singleton
    public Context providesContext() {
        return context.getApplicationContext();
    }


}
