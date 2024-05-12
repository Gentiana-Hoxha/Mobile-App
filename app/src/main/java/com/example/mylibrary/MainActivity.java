package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mylibrary.database.DatabaseManager;
import com.example.mylibrary.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editBookTitle, editBookAuthor, editBookGenre;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBookTitle = (EditText) findViewById(R.id.bookTitle);
        editBookAuthor = (EditText) findViewById(R.id.bookAuthor);
        editBookGenre = (EditText) findViewById(R.id.bookGenre);
        addButton = (Button) findViewById(R.id.addButton);

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