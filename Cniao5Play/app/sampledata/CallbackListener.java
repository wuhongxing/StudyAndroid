package com.example.cniao5play;

import java.io.InputStream;

public interface CallbackListener {
    void onSuccess(InputStream inputStream);
    void onFailure();
}
