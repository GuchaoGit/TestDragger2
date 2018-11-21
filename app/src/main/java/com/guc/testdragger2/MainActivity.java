package com.guc.testdragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.guc.testdragger2.bean.Cat;
import com.guc.testdragger2.component.DaggerMainComponent;

import javax.inject.Inject;
import javax.inject.Named;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Named("fish")
    @Inject
    Cat mCat;
    @Named("no_eat")
    @Inject
    Cat mCat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().build()
                .inject(this);
        Log.e(TAG, "eat: " + mCat);
        mCat.eat();
        Log.e(TAG, "eat: " + mCat2);
        mCat2.eat();
    }
}
