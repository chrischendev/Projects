package com.mars.edu.app.inject;

import com.mars.edu.app.pages.User;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class InjectModule {
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
