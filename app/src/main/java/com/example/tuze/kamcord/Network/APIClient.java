package com.example.tuze.kamcord.Network;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class APIClient {

    static final String API_BASE_URL = "https://api.kamcord.com/v1/feed/ZmVlZElkPWZlZWRfZmVhdHVyZWRfc2hvdCZ1c2VySWQmdG9waWNJZCZzdHJlYW1TZXNzaW9uSWQmbGFuZ3VhZ2VDb2Rl?count=20&page=";
    static final String ACCEPT_TAG="Accept";
    static final String ACCEPT_KEY="application/json";
    static final String DEVICE_TOKEN_TAG="device-token";
    static final String DEVICE_TOKEN_KEY="abc123;";
    static final String ACCEPT_LANG_TAG="accept-language";
    static final String ACCEPT_LANG_KEY="en";
    static final String CLIENT_NAME_TAG="client-name";
    static final String CLIENT_NAME_KEY="tugce";
    private OkHttpClient client;


    public APIClient() {
        this.client = new OkHttpClient();
    }

    public void getClient(String page, Callback callback) {
        String url=API_BASE_URL+page;

        Request request = new Request.Builder()
                .url(url)
                .addHeader(ACCEPT_TAG,ACCEPT_KEY)
                .addHeader(DEVICE_TOKEN_TAG,DEVICE_TOKEN_KEY)
                .addHeader(ACCEPT_LANG_TAG,ACCEPT_LANG_KEY)
                .addHeader(CLIENT_NAME_TAG, CLIENT_NAME_KEY)
                .build();

        client.newCall(request).enqueue(callback);
    }
}
