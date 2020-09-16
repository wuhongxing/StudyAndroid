package com.example.cniao5play;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

public class JsonHttpRequest implements IHttpRequest {
    private String url;
    private byte[] data;
    private CallbackListener mCallbackListener;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public void setCallbackListener(CallbackListener callbackListener) {
        this.mCallbackListener = callbackListener;
    }

    private URLConnection connection;
    @Override
    public void execute() {
        URL url = null;
        try {
            url = new URL(this.url);
            connection = url.openConnection();
            connection.setConnectTimeout(6000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
