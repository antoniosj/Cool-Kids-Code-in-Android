package com.antoniosj.cleanmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.antoniosj.cleanmvp.deps.DaggerDeps;
import com.antoniosj.cleanmvp.deps.Deps;
import com.antoniosj.cleanmvp.networking.NetworkModule;

import java.io.File;

public class BaseApp extends AppCompatActivity {

    Deps deps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "response");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDeps() {
        return deps;
    }
}
