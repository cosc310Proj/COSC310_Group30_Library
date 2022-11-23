package com.example.librarysystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BarnesAndNoblesApi {
    @GET("/recent/1")
    Call<List<BarnesAndNoblesBook>> getBooks();
}
