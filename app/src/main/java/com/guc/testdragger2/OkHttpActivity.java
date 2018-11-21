package com.guc.testdragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.guc.testdragger2.component.DaggerOkhttpComponent;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class OkHttpActivity extends AppCompatActivity {

    @Inject
    OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        DaggerOkhttpComponent.create().inject(this);
    }
}
