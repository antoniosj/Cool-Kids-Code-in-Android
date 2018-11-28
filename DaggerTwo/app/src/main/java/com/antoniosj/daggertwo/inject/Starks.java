package com.antoniosj.daggertwo.inject;

import android.util.Log;

import javax.inject.Inject;

public class Starks implements House{

    @Inject
    Allies allies;

    @Inject
    public Starks() {}

    @Override
    public void prepareForWar() {
        Log.d("DAGGER2", this.getClass().getSimpleName() + " RDY FOR WAR ");
    }

    @Override
    public void reportForWar() {

    }


}
