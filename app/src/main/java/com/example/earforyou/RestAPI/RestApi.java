package com.example.earforyou.RestAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


/**
 * This interface is the base of the retrofit implementation.
 */
public interface RestApi {
    @GET("test")
    Call<SimpleResponse> test();

    @POST("test")
    Call<SimpleResponse> testPost(@Body SimpleRequest simpleRequest);

    @PUT("cards")
    Call<Void> sendCard(@Body SetCardRequest cardRequest);

    @GET("cardsprev")
    Call<GetCardsPrevResponse> getCardsPrev();

    @POST("cards")
    Call<GetCardsPrevResponse>getCards(@Body GetCardsRequest getCardsRequest);


}
