package com.example.cniao5play.Dragger2;

import com.example.cniao5play.MainActivity;

@dagger.Component(modules = {Module.class})
public interface Component {
    void inject(MainActivity activity);
}
