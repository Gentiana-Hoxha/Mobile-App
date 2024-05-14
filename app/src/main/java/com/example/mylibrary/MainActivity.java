package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.mylibrary.adapters.BookAdapter;
import com.example.mylibrary.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addNewBookButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Little Women", "Louisa May Alcott", "Dram", "It is no surprise that Little Women, the adored classic of four devoted sisters, has been an avidly read tale for generations. Follow the sisters from innocent adolescence to sage adulthood, with all the joy and sorrow of life in between. Your life won’t be the same once you’ve met Meg, Jo, Beth, and Amy."));
        books.add(new Book("The Vanishing Half", "Brit Bennett", "Comedy", "A stunning novel about twin sisters, inseparable as children, who ultimately choose to live in two very different worlds, one black and one white. Looking well beyond issues of race, The Vanishing Half considers the lasting influence of the past as it shapes a person’s decisions, desires, and expectations, and explores some of the multiple reasons and realms in which people sometimes feel pulled to live as something other than their origins. Bennett offers an engrossing page-turner about family and relationships that is immersive and provocative, compassionate and wise"));
        books.add(new Book("Little Women", "Louisa May Alcott", "Dram", "It is no surprise that Little Women, the adored classic of four devoted sisters, has been an avidly read tale for generations. Follow the sisters from innocent adolescence to sage adulthood, with all the joy and sorrow of life in between. Your life won’t be the same once you’ve met Meg, Jo, Beth, and Amy."));
        books.add(new Book("The Vanishing Half", "Brit Bennett", "Comedy", "A stunning novel about twin sisters, inseparable as children, who ultimately choose to live in two very different worlds, one black and one white. Looking well beyond issues of race, The Vanishing Half considers the lasting influence of the past as it shapes a person’s decisions, desires, and expectations, and explores some of the multiple reasons and realms in which people sometimes feel pulled to live as something other than their origins. Bennett offers an engrossing page-turner about family and relationships that is immersive and provocative, compassionate and wise"));
        books.add(new Book("Little Women", "Louisa May Alcott", "Dram", "It is no surprise that Little Women, the adored classic of four devoted sisters, has been an avidly read tale for generations. Follow the sisters from innocent adolescence to sage adulthood, with all the joy and sorrow of life in between. Your life won’t be the same once you’ve met Meg, Jo, Beth, and Amy."));
        books.add(new Book("The Vanishing Half", "Brit Bennett", "Comedy", "A stunning novel about twin sisters, inseparable as children, who ultimately choose to live in two very different worlds, one black and one white. Looking well beyond issues of race, The Vanishing Half considers the lasting influence of the past as it shapes a person’s decisions, desires, and expectations, and explores some of the multiple reasons and realms in which people sometimes feel pulled to live as something other than their origins. Bennett offers an engrossing page-turner about family and relationships that is immersive and provocative, compassionate and wise"));
        books.add(new Book("Little Women", "Louisa May Alcott", "Dram", "It is no surprise that Little Women, the adored classic of four devoted sisters, has been an avidly read tale for generations. Follow the sisters from innocent adolescence to sage adulthood, with all the joy and sorrow of life in between. Your life won’t be the same once you’ve met Meg, Jo, Beth, and Amy."));
        books.add(new Book("The Vanishing Half", "Brit Bennett", "Comedy", "A stunning novel about twin sisters, inseparable as children, who ultimately choose to live in two very different worlds, one black and one white. Looking well beyond issues of race, The Vanishing Half considers the lasting influence of the past as it shapes a person’s decisions, desires, and expectations, and explores some of the multiple reasons and realms in which people sometimes feel pulled to live as something other than their origins. Bennett offers an engrossing page-turner about family and relationships that is immersive and provocative, compassionate and wise"));

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