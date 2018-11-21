package com.guc.testdragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.guc.testdragger2.bean.Product;
import com.guc.testdragger2.component.DaggerInjectWithNoModuleComponent;

import javax.inject.Inject;

public class InjectWithNoModuleActivity extends AppCompatActivity {

    @Inject
    Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inject_with_no_module);
        DaggerInjectWithNoModuleComponent.create().inject(this);
    }
}
