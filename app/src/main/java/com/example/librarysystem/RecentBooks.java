package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.librarysystem.JSONObjects.Books;
import com.example.librarysystem.JSONObjects.Lists;
import com.example.librarysystem.JSONObjects.Results;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecentBooks extends AppCompatActivity {
    private TextView recentBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_books);

        recentBooks = findViewById(R.id.textView8);
        recentBooks.setText("");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/books/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NYTBestSellersAPI nytBestSellersAPI = retrofit.create(NYTBestSellersAPI.class);

        Call<NYTBestSellersBook> call = nytBestSellersAPI.getBooks("2022-11-01");

        call.enqueue(new Callback<NYTBestSellersBook>() {
            @Override
            public void onResponse(Call<NYTBestSellersBook> call, Response<NYTBestSellersBook> response) {
                if(!response.isSuccessful()){
                    recentBooks.setText("Code: " + response.code());
                    return;
                }
                NYTBestSellersBook nytBestSellersBooks = response.body();


                    Results result = nytBestSellersBooks.getResults();
                    for(int x = 0; x < nytBestSellersBooks.getNum_results(); x++){
                        Lists[] lists = result.getLists();
                        for(Lists list : lists){
                            recentBooks.append(list.getDisplay_name() + "\n\n");

                            Books[] books = list.getBooks();
                            for(Books book : books){
                                String content = "";

                                content += "Title: " + book.getTitle() + "\n";
                                content += "Author: " + book.getAuthor() + "\n";
                                content += "Description: " + book.getDescription() + "\n";
                                content += "Rank: " + book.getRank() + "\n";
                                content += "Price: " + book.getPrice() + "\n\n";

                                recentBooks.append(content);
                            }

                            recentBooks.append("\n");
                        }
                    }

            }

            @Override
            public void onFailure(Call<NYTBestSellersBook> call, Throwable t) {
                recentBooks.setText(t.getMessage());
            }
        });
    }

    public void returnHome(View v){//return home button
        finish();
    }

    public void goLibraries(View v){
        Intent intent = new Intent(this, LibrariesNearby.class);
        startActivity(intent);
    }
}