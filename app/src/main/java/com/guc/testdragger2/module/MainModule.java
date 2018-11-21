package com.guc.testdragger2.module;

import com.guc.testdragger2.bean.Cat;
import com.guc.testdragger2.bean.Fish;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by guc on 2018/11/21.
 * 描述：@Module
 */
//第一步：添加@module注解
@Module
public class MainModule {
    //第二步 使用Provider 注解 实例化对象
    @Named("fish")
    @Provides
    Cat provideCatHasFish(Fish fish) {
        return new Cat(fish);
    }

    @Named("no_eat")
    @Provides
    Cat provideCat() {
        return new Cat();
    }

    @Provides
    Fish provideFish() {
        return new Fish();
    }

}
