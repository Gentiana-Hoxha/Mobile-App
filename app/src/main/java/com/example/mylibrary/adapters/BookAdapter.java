package com.example.mylibrary.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mylibrary.EditBookActivity;
import com.example.mylibrary.R;
import com.example.mylibrary.models.Book;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    private final Context context;

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
        }


        TextView tvTitle = convertView.findViewById(R.id.text_view_title);
        TextView tvAuthor = convertView.findViewById(R.id.text_view_author);
        TextView tvGenre = convertView.findViewById(R.id.text_view_genre);
        TextView tvSynopsis = convertView.findViewById(R.id.text_view_synopsis);

        if (book != null) {
            tvTitle.setText(book.getTitle());
            tvAuthor.setText("by " + book.getAuthor());
            tvGenre.setText(book.getGenre());
            if(book.getSynopsis().length() > 100) {
                tvSynopsis.setText(book.getSynopsis().substring(0, 100) + "...");
            } else {
                tvSynopsis.setText(book.getSynopsis());
            }
        }

        convertView.setOnClickListener(view -> {
            Intent redirectToEditBook = new Intent(context, EditBookActivity.class);

            long bookId = book.getId();

            redirectToEditBook.putExtra("key", bookId);
            context.startActivity(redirectToEditBook);
        });

        return convertView;
    }
}
