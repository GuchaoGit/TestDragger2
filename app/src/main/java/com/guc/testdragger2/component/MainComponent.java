package com.guc.testdragger2.component;

import com.guc.testdragger2.MainActivity;
import com.guc.testdragger2.module.MainModule;

import dagger.Component;

/**
 * Created by guc on 2018/11/21.
 * 描述：@Component
 */
//第一步 添加@Component
//第二步 添加module
@Component(modules = MainModule.class)
public interface MainComponent {
    //第三步  写一个方法 绑定Activity /Fragment
    void inject(MainActivity activity);
}
