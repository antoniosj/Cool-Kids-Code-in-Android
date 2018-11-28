package com.antoniosj.daggertwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antoniosj.daggertwo.inject.BattleComponent;
import com.antoniosj.daggertwo.inject.Cash;
import com.antoniosj.daggertwo.inject.DaggerBattleComponent;
import com.antoniosj.daggertwo.inject.Soldier;
import com.antoniosj.daggertwo.inject.War;
import com.antoniosj.daggertwo.inject.modules.BraavosModule;
import com.antoniosj.daggertwo.noinject.BoltonsNI;
import com.antoniosj.daggertwo.noinject.StarkNI;
import com.antoniosj.daggertwo.noinject.WarMI;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StarkNI starkNI = new StarkNI();
        BoltonsNI boltonsNI = new BoltonsNI();

        WarMI warMI = new WarMI(starkNI, boltonsNI);
        warMI.prepare();
        warMI.report();

        Cash cash = new Cash();
        Soldier soldier = new Soldier();

        BattleComponent component = DaggerBattleComponent.builder().braavosModule(new BraavosModule(cash, soldier)).build();

        War war = component.getWar();

        component.getSoldiers();
        component.getCash();

        war.prepare();
        war.report();


    }
}
