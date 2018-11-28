package com.antoniosj.daggertwo.noinject;

import android.util.Log;


public class StarkNI implements HouseNI {
    @Override
    public void prepareForWar() {
       Log.d("NOINJECT",this.getClass().getSimpleName()+" prepared for war");
    }

    @Override
    public void reportForWar() {
        Log.d("NOINJECT",this.getClass().getSimpleName()+" reporting...");
    }
}
