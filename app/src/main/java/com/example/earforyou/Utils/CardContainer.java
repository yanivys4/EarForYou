package com.example.earforyou.Utils;

import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class CardContainer {

    private CardView cardView;
    private TextView title;
    private TextView prev;
    private TextView likeCount;
    private TextView commentCount;
    private TextView date;

    public TextView getTitle() {
        return title;
    }

    public TextView getPrev() {
        return prev;
    }

    public TextView getLikeCount() {
        return likeCount;
    }

    public TextView getCommentCount() {
        return commentCount;
    }

    public CardView getCardView() {
        return cardView;
    }

    public TextView getDate() {
        return date;
    }

    public CardContainer(CardView cardView, TextView title, TextView prev, TextView likeCount, TextView commentCount, TextView date) {
        this.cardView = cardView;
        this.title = title;
        this.prev = prev;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.date = date;
    }
}
