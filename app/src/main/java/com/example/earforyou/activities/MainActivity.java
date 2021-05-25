package com.example.earforyou.activities;

import com.example.earforyou.R;
import com.example.earforyou.RestAPI.CardPrev;
import com.example.earforyou.RestAPI.GetCardsPrevResponse;
import com.example.earforyou.RestAPI.GetCardsRequest;
import com.example.earforyou.RestAPI.RestApi;
import com.example.earforyou.RestAPI.RetrofitClient;
import com.example.earforyou.Utils.CardContainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    private static final String ACTION_MAIN_ACTIVITY =
            "android.intent.action.ACTION_MAIN_ACTIVITY_EAR_FOR_YOU";
    private GetCardsPrevResponse getCardsPrevResponse;
    private ArrayList<CardContainer> cardContainerArray;
    private ProgressBar progressBar;
    private CardContainer card1;
    private CardContainer card2;
    private CardContainer card3;
    private CardContainer card4;

    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;

    private TextView title1;
    private TextView title2;
    private TextView title3;
    private TextView title4;

    private TextView prev1;
    private TextView prev2;
    private TextView prev3;
    private TextView prev4;

    private TextView likeCount1;
    private TextView likeCount2;
    private TextView likeCount3;
    private TextView likeCount4;

    private TextView commentCount1;
    private TextView commentCount2;
    private TextView commentCount3;
    private TextView commentCount4;

    private TextView date1;
    private TextView date2;
    private TextView date3;
    private TextView date4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initCardContainers();

        getCardsPrev();

    }

    public static Intent makeIntent() {
        return new Intent(ACTION_MAIN_ACTIVITY);
    }

    private void initializeViews() {
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        cardView1 = findViewById(R.id.card_view1);
        cardView2 = findViewById(R.id.card_view2);
        cardView3 = findViewById(R.id.card_view3);
        cardView4 = findViewById(R.id.card_view4);


        title1 = findViewById(R.id.title1);
        title2 = findViewById(R.id.title2);
        title3 = findViewById(R.id.title3);
        title4 = findViewById(R.id.title4);

        prev1 = findViewById(R.id.prev1);
        prev2 = findViewById(R.id.prev2);
        prev3 = findViewById(R.id.prev3);
        prev4 = findViewById(R.id.prev4);

        likeCount1 = findViewById(R.id.like_count1);
        likeCount2 = findViewById(R.id.like_count2);
        likeCount3 = findViewById(R.id.like_count3);
        likeCount4 = findViewById(R.id.like_count4);

        commentCount1 = findViewById(R.id.comment_count1);
        commentCount2 = findViewById(R.id.comment_count2);
        commentCount3 = findViewById(R.id.comment_count3);
        commentCount4 = findViewById(R.id.comment_count4);

        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        date3 = findViewById(R.id.date3);
        date4 = findViewById(R.id.date4);
    }

    private void getCardsPrev(){
        Retrofit retrofit = RetrofitClient.getInstance();
        // retrofit create rest api according to the interface
        RestApi restApi = retrofit.create(RestApi.class);
        Call<GetCardsPrevResponse> call = restApi.getCardsPrev();
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<GetCardsPrevResponse>(){

            @Override
            public void onResponse(Call<GetCardsPrevResponse> call, Response<GetCardsPrevResponse> response) {
                if(!response.isSuccessful()){
                    System.out.println("error");
                }else{
                    getCardsPrevResponse = response.body();
                    fillData(getCardsPrevResponse.getCardPrevs());
                    //setOnClick();
                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<GetCardsPrevResponse> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    private void initCardContainers(){
        card1 = new CardContainer(cardView1,title1,prev1,likeCount1,commentCount1, date1);
        card2 = new CardContainer(cardView2,title2,prev2,likeCount2,commentCount2, date2);
        card3 = new CardContainer(cardView3,title3,prev3,likeCount3,commentCount3, date3);
        card4 = new CardContainer(cardView4,title4,prev4,likeCount4,commentCount4, date4);
        cardContainerArray = new ArrayList<>();
        cardContainerArray.add(card1);
        cardContainerArray.add(card2);
        cardContainerArray.add(card3);
        cardContainerArray.add(card4);

        cardView1.setVisibility(View.GONE);
        cardView2.setVisibility(View.GONE);
        cardView3.setVisibility(View.GONE);
        cardView4.setVisibility(View.GONE);

    }

    private void fillData(ArrayList<CardPrev> arrayOfCardPrevs){
        for(int i=0; i < arrayOfCardPrevs.size() ; ++i){
            CardContainer cardContainer = cardContainerArray.get(i);
            CardPrev cardPrev = arrayOfCardPrevs.get(i);
            cardContainer.getCardView().setVisibility(View.VISIBLE);
            cardContainer.getTitle().setText(cardPrev.getTitle());
            cardContainer.getPrev().setText(cardPrev.getPrev()+ "...");
            cardContainer.getLikeCount().setText(cardPrev.getNumOfLikes());
            cardContainer.getCommentCount().setText(cardPrev.getNumOfComments());
            cardContainer.getDate().setText(cardPrev.getDate());

        }
    }

    private void setOnClick(){
        ArrayList<CardPrev> cardsPrev = getCardsPrevResponse.getCardPrevs();
        cardView1.setOnClickListener(v -> {
            openCard(cardsPrev.get(0).getUuid());
        });
        cardView2.setOnClickListener(v -> {
            openCard(cardsPrev.get(1).getUuid());
        });
        cardView3.setOnClickListener(v -> {
            openCard(cardsPrev.get(2).getUuid());
        });
        cardView4.setOnClickListener(v -> {
            openCard(cardsPrev.get(3).getUuid());
        });
    }


    private void openCard(String uuid){
        Retrofit retrofit = RetrofitClient.getInstance();
        // retrofit create rest api according to the interface
        RestApi restApi = retrofit.create(RestApi.class);
        GetCardsRequest getCardsRequest = new GetCardsRequest(uuid);
        Call<GetCardsPrevResponse> call = restApi.getCards(getCardsRequest);
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<GetCardsPrevResponse>(){

            @Override
            public void onResponse(Call<GetCardsPrevResponse> call, Response<GetCardsPrevResponse> response) {
                if(!response.isSuccessful()){
                    System.out.println(response.code());
                }else{
                    GetCardsPrevResponse getCardsResponse = response.body();
                    System.out.println(getCardsPrevResponse.getCardPrevs().get(0).toString());
                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<GetCardsPrevResponse> call, Throwable t) {
                System.out.println(t);
            }
        });

    }
}
