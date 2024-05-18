package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.mylibrary.adapters.BookAdapter;
import com.example.mylibrary.databases.DatabaseHelper;
import com.example.mylibrary.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addNewBookButton;
    private LinearLayout noBooksPlaceholder;
    private DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noBooksPlaceholder = findViewById(R.id.noBooksPlaceholder);
        addNewBookButton = findViewById(R.id.addBookButton);

        BookAdapter adapter = new BookAdapter(this, this.getBooks());

        GridView gridView = findViewById(R.id.booksList);
        gridView.setAdapter(adapter);



        addNewBookButton.setOnClickListener(view -> {
            Intent redirectToAddNewBook = new Intent(MainActivity.this, AddBookActivity.class);
            startActivity(redirectToAddNewBook);
        });
    }

    private ArrayList<Book> getBooks() {
        ArrayList<Book> books = dbHelper.getAllBooks();

        if(books.isEmpty()) {
            noBooksPlaceholder.setVisibility(View.VISIBLE);
        } else {
            noBooksPlaceholder.setVisibility(View.GONE);
        }

        return books;
    }
}