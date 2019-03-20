package com.antoniosj.gridapplication;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DataGenerator {

    public static List<Integer> getNatureImages(Context ctx) {
        List<Integer> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.sample_images);
        for (int i = 0; i < drw_arr.length(); i++) {
            items.add(drw_arr.getResourceId(i, -1));
        }
        Collections.shuffle(items);
        return items;
    }

}
