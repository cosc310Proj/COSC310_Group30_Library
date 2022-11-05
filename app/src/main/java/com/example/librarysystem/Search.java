package com.example.librarysystem;

import static com.example.librarysystem.login.lOB;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    ArrayList<Book> listOfBooks;
    TableLayout displayBooks;//creating references

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting user Key


        lOB.read(getApplicationContext()); //  BookList lOB = new BookList();
        listOfBooks = lOB.getBookList();
        displayBooks= (TableLayout) findViewById(R.id.displayBooks);//casting table

        for(int i=0;i<listOfBooks.size();i++) {//creating table

            Book fill = listOfBooks.get(i);//iterating through books
            TableRow row = new TableRow(this);//creating row
            if (fill.checkedOut == false) {

                String title = fill.title;//creating title view
                TextView titleView = new TextView(this);
                titleView.setText("" + title);
                titleView.setTextColor(titleView.getContext().getColor(R.color.teal_700));
                titleView.setClickable(true);//set the title text to clickable
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        advancedBookView(fill);
                    }
                });
                Button checkout = new Button(this);//creating checkout Buttons
                checkout.setTag(fill);
                checkout.setText("Checkout");
                checkout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fill.checkedOut = true;//if button is pressed update field
                        //update the file so it contains the book as checked out
                        BookList lOB = new BookList(listOfBooks);
                        lOB.writeToFile(lOB, getApplicationContext());
                        restart();
                    }

                });

                row.addView(titleView);//adding both bits to table
                row.addView(checkout);
                displayBooks.addView(row);

            }
        }
    }


    public void returnHome(View v){//return home button
        Intent intent= new Intent(this, UserMain.class);
        startActivity(intent);

    }

    //Restarts activity to show changes
    public void restart(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }
    public void advancedBookView(Book book){
            Intent intent=new Intent(this, book_Description.class);
            Bundle bundle=new Bundle();
            bundle.putString("title",book.title);
            bundle.putString("author",book.author);//Adding needed resources for advanced view
            bundle.putString("genre",book.genre);
            //bundle.putString("description",book.description);

            intent.putExtras(bundle);
            startActivity(intent);//starting activity

    }
}