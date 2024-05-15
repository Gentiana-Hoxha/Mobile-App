package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.mylibrary.adapters.BookAdapter;
import com.example.mylibrary.databases.DatabaseHelper;
import com.example.mylibrary.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addNewBookButton;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> books = new ArrayList<>();

        Cursor cursor = dbHelper.getBooks();
//        if (cursor.moveToFirst()) {
//            do {
//                String title = cursor.getString(1);
//                String author = cursor.getString(2);
//                String genre = cursor.getString(3);
//                String synopsis = cursor.getString(4);
//
//                books.add(new Book(title, author, genre, synopsis));
//            } while (cursor.moveToNext());
//        }
        cursor.close();

        BookAdapter adapter = new BookAdapter(this, books);

        GridView gridView = findViewById(R.id.booksList);
        gridView.setAdapter(adapter);

        addNewBookButton = findViewById(R.id.addBookButton);

        addNewBookButton.setOnClickListener(view -> {
            Intent redirectToAddNewBook = new Intent(MainActivity.this, AddBookActivity.class);
            startActivity(redirectToAddNewBook);
        });
    }
}