package com.example.earforyou.RestAPI;

public class CardPrev {
    private String numOfLikes;
    private String numOfComments;
    private String title;
    private String prev;
    private String uuid;
    private String date;

    public CardPrev(String numOfLikes, String numOfComments, String title, String prev, String uuid, String date) {
        this.numOfLikes = numOfLikes;
        this.numOfComments = numOfComments;
        this.title = title;
        this.prev = prev;
        this.uuid = uuid;
        this.date = date;
    }

    public String getNumOfLikes() {
        return numOfLikes;
    }

    public String getNumOfComments() {
        return numOfComments;
    }

    public String getTitle() {
        return title;
    }

    public String getPrev() {
        return prev;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString(){
        String result = "";
        result += "num of likes: " + numOfLikes + '\n';
        result += "num of comments: " + numOfComments + '\n';
        result += "title: " + title + '\n';
        result += "prev: " + prev + '\n';
        result += "uuid: " + uuid + '\n';
        result += "date: " + date + '\n';

        return result;
    }
}
