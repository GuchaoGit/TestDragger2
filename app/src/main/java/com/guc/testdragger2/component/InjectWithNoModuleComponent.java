package com.guc.testdragger2.component;

import com.guc.testdragger2.InjectWithNoModuleActivity;

import dagger.Component;

/**
 * Created by guc on 2018/11/21.
 * 描述：@Component
 */
//第一步 添加@Component
@Component
public interface InjectWithNoModuleComponent {
    //第二步  写一个方法 绑定Activity /Fragment
    void inject(InjectWithNoModuleActivity activity);
}
