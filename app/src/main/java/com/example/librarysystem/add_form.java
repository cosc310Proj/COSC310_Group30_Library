package com.example.librarysystem;

import static com.example.librarysystem.login.books;
import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class add_form extends AppCompatActivity {
    ArrayList<Book> list;
    String title, author, genre;
    EditText titleText, authorText, genreText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
    }

    public void addBook (View view){
        titleText = (EditText) findViewById(R.id.titleField);
        authorText = (EditText) findViewById(R.id.authorField);
        genreText = (EditText) findViewById(R.id.genreField);


        title = titleText.getText().toString();
        author = authorText.getText().toString();
        genre = genreText.getText().toString();

     //Gets the current booklist, adds the new book, and changes the master list

        if (title.isEmpty())  {
            Toast t1 = Toast.makeText(getApplicationContext(), "Please enter a book title", Toast.LENGTH_SHORT);
            t1.show();
        } else if (author.isEmpty()){
            Toast t1 = Toast.makeText(getApplicationContext(), "Please enter an author", Toast.LENGTH_SHORT);
            t1.show();
        } else if (genre.isEmpty()){
            Toast t1 = Toast.makeText(getApplicationContext(), "Please enter a genre", Toast.LENGTH_SHORT);
            t1.show();
        } else {
        lOB.read(getApplicationContext());
        list = lOB.getBookList();
        list.add(new Book(login.id, title, author, genre));
        lOB = new BookList(list);
    lOB.writeToFile(lOB, getApplicationContext());
            Toast t1 = Toast.makeText(getApplicationContext(), title + " has been added", Toast.LENGTH_SHORT);
            t1.show();
            restart();
        }
    }

    public void restart(){
        Intent intent = new Intent(this, add_form.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }

    public void back (View view) {
        Intent intent= new Intent(this, ManageBooks.class);
        startActivity(intent);

    }

}