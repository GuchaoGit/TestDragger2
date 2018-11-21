package com.guc.testdragger2.module;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by guc on 2018/11/21.
 * 描述：
 */
@Module
public class OkhttpModule {
    public static final int TIME_OUT_CONNECT = 20;
    public static final int TIME_OUT_READ = 30;
    public static final int TIME_OUT_WRITE = 40;
    private static final String TAG = "OkhttpModule";

    @Provides
    OkHttpClient provideOkHttpClient() {
        Log.e(TAG, "provideOkHttpClient: create okhttpclient");
        return createOkHttpClient();
    }


    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(createHttpLoggingInterceptor());
        return builder.connectTimeout(TIME_OUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT_WRITE, TimeUnit.SECONDS)
                .build();
    }

    private HttpLoggingInterceptor createHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
