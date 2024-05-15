package com.example.mylibrary.databases;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mylibrary.models.Book;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "library.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_BOOKS = "Library";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_SYNOPSIS = "synopsis";

    private static final String SQL_CREATE_BOOKS_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_BOOKS + " (" +
                    COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_TITLE + " TEXT NOT NULL," +
                    COLUMN_AUTHOR + " TEXT NOT NULL," +
                    COLUMN_GENRE + " TEXT," +
                    COLUMN_SYNOPSIS + " TEXT);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }
    public boolean createBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, book.getTitle());
        values.put(COLUMN_AUTHOR, book.getAuthor());
        values.put(COLUMN_GENRE, book.getGenre());
        values.put(COLUMN_SYNOPSIS, book.getSynopsis());
        long result = db.insert(TABLE_BOOKS, null, values);
        return result != -1;
    }

    public Cursor getBooks() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String [] columns = new String[] {COLUMN_ID, COLUMN_TITLE, COLUMN_AUTHOR, COLUMN_GENRE, COLUMN_SYNOPSIS};
        Cursor cursor = sqLiteDatabase.query(TABLE_BOOKS, columns, null, null, null, null, null, null);
        
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
