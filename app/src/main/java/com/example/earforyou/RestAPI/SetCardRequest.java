package com.example.earforyou.RestAPI;

import java.util.ArrayList;

public class SetCardRequest {
    private String title;
    private String content;
    private ArrayList<String> tags;

    public SetCardRequest(String title, String content, ArrayList<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

}
