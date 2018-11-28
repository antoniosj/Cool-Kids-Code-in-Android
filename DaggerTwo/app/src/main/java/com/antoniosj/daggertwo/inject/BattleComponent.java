package com.antoniosj.daggertwo.inject;

import com.antoniosj.daggertwo.inject.modules.BraavosModule;

import dagger.Component;

@Component(modules = BraavosModule.class)
public interface BattleComponent {
    War getWar();

    //part2
    Cash getCash();
    Soldier getSoldiers();

}
