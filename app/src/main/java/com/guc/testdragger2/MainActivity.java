package com.guc.testdragger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.guc.testdragger2.bean.Cat;
import com.guc.testdragger2.bean.Product;
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

    @Inject
    Product mProduct;
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

    public void next(View view) {
        startActivity(new Intent(this, InjectWithNoModuleActivity.class));
    }
}
