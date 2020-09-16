package com.example.cniao5play.Dragger2;

import dagger.Provides;

@dagger.Module
public class Module {
    @Provides
    public Service provideService() {
        return new Service();
    }
}
