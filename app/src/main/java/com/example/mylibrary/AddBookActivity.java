package com.example.mylibrary;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {
    private EditText editBookTitle, editBookAuthor, editBookGenre, editBookSynopsis;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

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

    public void lexo(View v) {
        String title = String.valueOf(editBookTitle.getText());
        String author = String.valueOf(editBookAuthor.getText());
        Toast.makeText(getApplicationContext(), "Libri " + title + ", shkruar nga " + author, Toast.LENGTH_LONG).show();
    }
}