package com.antoniosj.daggertwo.noinject;

public class WarNI {

    private StarkNI starks;

    private BoltonsNI boltons;

    //dependencia - war depende de stark e bolton
    public WarNI(){

        starks = new StarkNI();
        boltons = new BoltonsNI();

        starks.prepareForWar();
        starks.reportForWar();
        boltons.prepareForWar();
        starks.reportForWar();
    }
}
