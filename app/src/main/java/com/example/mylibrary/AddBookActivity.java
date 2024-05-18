package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.databases.DatabaseHelper;
import com.example.mylibrary.models.Book;

public class AddBookActivity extends AppCompatActivity {
    private EditText editBookTitle, editBookAuthor, editBookGenre, editBookSynopsis;
    private Button addButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        cancelButton = findViewById(R.id.cancel);
        editBookTitle = (EditText) findViewById(R.id.bookTitle);
        editBookAuthor = (EditText) findViewById(R.id.bookAuthor);
        editBookGenre = (EditText) findViewById(R.id.bookGenre);
        editBookSynopsis = (EditText) findViewById(R.id.bookSynopsis);
        addButton = (Button) findViewById(R.id.createBook);

        listenForInputChange();
    }

    public void listenForInputChange() {
        editBookTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(editBookTitle.getText().toString().trim().length() > 0
                        && editBookAuthor .getText().toString().trim().length() > 0 );
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editBookAuthor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(editBookTitle.getText().toString().trim().length() > 0
                        && editBookAuthor .getText().toString().trim().length() > 0 );
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void createBook(View v) {
        try {
            Book book = new Book(
                    editBookTitle.getText().toString(),
                    editBookAuthor.getText().toString(),
                    editBookGenre.getText().toString(),
                    editBookSynopsis.getText().toString());

            DatabaseHelper db = new DatabaseHelper(AddBookActivity.this);
            if (db.addBook(book))
                Toast.makeText(AddBookActivity.this, "New book added to the Library", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(AddBookActivity.this, "Something went wrong, please try again later!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(AddBookActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        Intent redirectToMainPage = new Intent(AddBookActivity.this, MainActivity.class);
        startActivity(redirectToMainPage);
    }

    public void goBackToMainPage(View v) {
        Intent redirectToMainPage = new Intent(AddBookActivity.this, MainActivity.class);
        startActivity(redirectToMainPage);
    }
}