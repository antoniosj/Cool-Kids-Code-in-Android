package com.antoniosj.daggertwo.noinject;


//manually injection
public class WarMI {

    private StarkNI starks;

    private BoltonsNI boltons;

    public WarMI(StarkNI starks, BoltonsNI boltons) {

        this.starks = starks;
        this.boltons = boltons;
    }


    public void prepare() {
        starks.prepareForWar();
        boltons.reportForWar();
    }

    public void report() {
        starks.reportForWar();
        boltons.reportForWar();
    }
}
