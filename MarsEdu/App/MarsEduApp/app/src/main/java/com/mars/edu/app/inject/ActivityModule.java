package com.mars.edu.app.inject;

import com.mars.edu.app.model.User;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author Chris Chan
 * on 2019/7/5 14:51
 * use for:
 */
@Module
public class ActivityModule {
    @Provides
    public User user() {
        return new User("kaly", 40);
    }

    @Provides
    public List<String> userNames() {
        String[] names = {"孙菲菲", "姚诗涵", "杨幂"};
        return Arrays.asList(names);
    }
}
