package com.example.android.booklistingapp;

/**
 * Created by thema on 14/12/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by thema on 03/12/2017.
 */

public class BookAdapter extends ArrayAdapter<Book>  {

    public BookAdapter(Context context, List<Book> books){

        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_list_item, parent, false);
        }

        Book currentBook = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentBook.getBookTitle());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        authorTextView.setText(currentBook.getAuthor());




        return listItemView;

    }
}

