package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

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
                .baseUrl("http://barnesandnobles.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BarnesAndNoblesApi barnesAndNoblesApi = retrofit.create(BarnesAndNoblesApi.class);

        Call<List<BarnesAndNoblesBook>> call = barnesAndNoblesApi.getBooks();

        call.enqueue(new Callback<List<BarnesAndNoblesBook>>() {
            @Override
            public void onResponse(Call<List<BarnesAndNoblesBook>> call, Response<List<BarnesAndNoblesBook>> response) {
                if(!response.isSuccessful()){
                    recentBooks.setText("Code: " + response.code());
                    return;
                }
                List<BarnesAndNoblesBook> barnesAndNoblesBooks = response.body();

                for(BarnesAndNoblesBook bNB : barnesAndNoblesBooks){
                    String content = "";
                    content += "Title: " + bNB.getTitle() + "\n";
                    content += "Author: " + bNB.getAuthor() + "\n";
                    content += "Rating: " + bNB.getRating() + "\n";
                    content += "Price: " + bNB.getPrice() + "\n";
                    content += "Pages: " + bNB.getPages() + "\n";
                    content += "Description: " + bNB.getDescription() + "\n\n";

                    recentBooks.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<BarnesAndNoblesBook>> call, Throwable t) {
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