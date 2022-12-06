package com.example.librarysystem;

import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NYTBestSellersAPI {
    @GET("lists/overview.json?api-key=5eifMVucZefXzgZWxdcsykNKvM1BbYn5")
    Call<NYTBestSellersBook> getBooks(
            @Query("published_date") String date
    );
}

/*
@GET("/stockers/login")
public void login(
        @Query("email") String email,
        @Query("password") String password,
        Callback<JSONObject> callback);
 */
