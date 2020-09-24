package com.example.lesson1.object;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides
    public DatabaseObject providerDatabaseObject() { return new DatabaseObject(); }
}
