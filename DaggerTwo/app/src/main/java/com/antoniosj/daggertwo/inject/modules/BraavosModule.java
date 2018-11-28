package com.antoniosj.daggertwo.inject.modules;

import com.antoniosj.daggertwo.inject.Cash;
import com.antoniosj.daggertwo.inject.Soldier;

import dagger.Module;
import dagger.Provides;

@Module
public class BraavosModule {

    Cash cash;
    Soldier soldiers;

    public BraavosModule(Cash cash, Soldier soldiers){
        this.cash=cash;
        this.soldiers=soldiers;
    }

    @Provides
        //Provides cash dependency
    Cash provideCash(){
        return cash;
    }

    @Provides //provides soldiers dependency
    Soldier provideSoldiers(){
        return soldiers;
    }

}
