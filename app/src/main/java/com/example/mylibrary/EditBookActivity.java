package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

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
        long id = intent.getLongExtra("key", 0);

        try {
            Book book = db.getBookById(id);
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

            listenForInputChange();
            listenForEditBook();
            listenForDeleteBook(id);
        } catch (Error error) {

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

    private void listenForEditBook() {
        editBookAuthor.setOnClickListener(view2 -> {
            Book book = new Book(
                    editBookTitle.getText().toString(),
                    editBookAuthor.getText().toString(),
                    editBookGenre.getText().toString(),
                    editBookSynopsis.getText().toString());

            db.editBook(book);
            goBackToMainPage();
        });
    }

    private void listenForDeleteBook(long id) {
        deleteBook.setOnClickListener(view3 -> {
            db.deleteBook(id);
            goBackToMainPage();
        });
    }

    private void goBackToMainPage() {
        Intent redirectToMain = new Intent(EditBookActivity.this, MainActivity.class);
        startActivity(redirectToMain);
    }
}