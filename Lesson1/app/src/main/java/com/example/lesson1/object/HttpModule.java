package com.example.lesson1.object;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpObject providerHttpObject() { return new HttpObject(); }
}
