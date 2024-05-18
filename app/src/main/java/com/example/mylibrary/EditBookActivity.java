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

public class EditBookActivity extends AppCompatActivity {
    private EditText editBookTitle, editBookAuthor, editBookGenre, editBookSynopsis;
    private Button editBook, deleteBook;
    private DatabaseHelper db = new DatabaseHelper(EditBookActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        Intent intent = getIntent();
        int id = intent.getIntExtra("key", 0);

        try {
            Book book = db.getBook(id);
            editBookTitle = (EditText) findViewById(R.id.bookTitle);
            editBookAuthor = (EditText) findViewById(R.id.bookAuthor);
            editBookGenre = (EditText) findViewById(R.id.bookGenre);
            editBookSynopsis = (EditText) findViewById(R.id.bookSynopsis);

            editBook = (Button) findViewById(R.id.editBook);
            deleteBook = (Button) findViewById(R.id.deleteBook);

            editBookTitle.setText(book.getTitle());
            editBookAuthor.setText(book.getAuthor());
            editBookGenre.setText(book.getGenre());
            editBookSynopsis.setText(book.getSynopsis());

            editBook.setEnabled(true);

            listenForInputChange();
            listenForEditBook(id);
            listenForDeleteBook(id);
        } catch (Error error) {
            Toast.makeText(EditBookActivity.this, "Something went wrong while trying to edit Book, please try again later", Toast.LENGTH_SHORT).show();

        }
    }

    public void listenForInputChange() {
        editBookTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editBook.setEnabled(editBookTitle.getText().toString().trim().length() > 0
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
                editBook.setEnabled(editBookTitle.getText().toString().trim().length() > 0
                        && editBookAuthor .getText().toString().trim().length() > 0 );
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void listenForEditBook(int id) {
        editBook.setOnClickListener(view -> {
            Book book = new Book(
                    id,
                    editBookTitle.getText().toString(),
                    editBookAuthor.getText().toString(),
                    editBookGenre.getText().toString(),
                    editBookSynopsis.getText().toString());

            db.updateBook(book);
            Intent redirectToMain = new Intent(this, MainActivity.class);
            startActivity(redirectToMain);
        });
    }

    private void listenForDeleteBook(int id) {
        deleteBook.setOnClickListener(view -> {
            db.deleteBook(id);
            Intent redirectToMainPage = new Intent(this, MainActivity.class);
            startActivity(redirectToMainPage);
        });
    }

    public void goBackToMainPage(View v) {
        Intent redirectToMain = new Intent(this, MainActivity.class);
        startActivity(redirectToMain);
    }
}