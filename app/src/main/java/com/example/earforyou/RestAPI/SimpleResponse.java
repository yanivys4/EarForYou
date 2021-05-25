package com.example.earforyou.RestAPI;

public class SimpleResponse {
    private final String msg;

    public SimpleResponse(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
