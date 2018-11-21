package com.guc.testdragger2.bean;

import android.text.TextUtils;
import android.util.Log;


/**
 * Created by guc on 2018/11/21.
 * 描述：
 */
public class Cat {
    private static final String TAG = "Cat";
    private String name;
    private Fish mFish;

    public Cat(Fish fish) {
        this.mFish = fish;
    }

    public Cat() {
    }

    public void eat() {
        Log.e(TAG, TextUtils.isEmpty(name) ? "eat:吃鱼 " : name + " eat:吃鱼");
        if (mFish != null) {
            mFish.eat();
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
