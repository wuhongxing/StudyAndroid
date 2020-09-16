package com.example.cniao5play;

import android.telecom.Call;

public interface IHttpRequest {
    void setUrl(String url);
    void setData(byte[] data);
    void setCallbackListener(CallbackListener callbackListener);
    void execute();
}
