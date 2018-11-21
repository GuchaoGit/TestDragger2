package com.guc.testdragger2.component;

import com.guc.testdragger2.OkHttpActivity;
import com.guc.testdragger2.module.OkhttpModule;

import dagger.Component;

/**
 * Created by guc on 2018/11/21.
 * 描述：
 */
@Component(modules = OkhttpModule.class)
public interface OkhttpComponent {
    void inject(OkHttpActivity activity);
}
