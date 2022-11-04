package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class book_Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_description);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting descriptions

        TextView title= (TextView) findViewById(R.id.textView4);
        title.setText(bundle.getString("title"));
    }
    public void returnHomeSearch(View v){//return home button
        Intent intent= new Intent(this, Search.class);
        startActivity(intent);

    }
}