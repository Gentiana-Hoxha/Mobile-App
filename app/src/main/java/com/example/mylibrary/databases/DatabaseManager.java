package com.example.mylibrary.databases;
import com.example.mylibrary.models.Book;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;
import java.util.ArrayList;

public class DatabaseManager {
    private DatabaseHelper databaseHelper;
    private Context context;
    private SQLiteDatabase database;


    public DatabaseManager(Context context) {
        this.context = context;
    }

    public DatabaseManager open() throws SQLDataException {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        databaseHelper.close();
    }

    public boolean createBook(Book book) {
        return databaseHelper.createBook(book);
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        Cursor cursor = databaseHelper.getBooks();

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(1);
                String author = cursor.getString(2);
                String genre = cursor.getString(3);
                String synopsis = cursor.getString(4);

                books.add(new Book(title, author, genre, synopsis));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return books;
    }
}

