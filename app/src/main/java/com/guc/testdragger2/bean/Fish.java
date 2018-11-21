package com.guc.testdragger2.bean;

import android.text.TextUtils;
import android.util.Log;


/**
 * Created by guc on 2018/11/21.
 * 描述：
 */
public class Fish {
    private static final String TAG = "Fish";
    private String name;

    public void eat() {
        Log.e(TAG, TextUtils.isEmpty(name) ? "eat:吃虾 " : name + " eat:吃虾");
    }

    public void setName(String name) {
        this.name = name;
    }
}
