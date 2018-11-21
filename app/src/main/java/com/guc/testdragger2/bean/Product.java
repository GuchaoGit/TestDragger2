package com.guc.testdragger2.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by guc on 2018/11/21.
 * 描述：
 */
public class Product {
    private static final String TAG = "Product";

    @Inject
    public Product() {
        Log.e(TAG, "Product: create");
    }
}
