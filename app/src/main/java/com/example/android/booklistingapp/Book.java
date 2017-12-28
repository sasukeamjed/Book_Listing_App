package com.example.android.booklistingapp;

/**
 * Created by thema on 14/12/2017.
 */

public class Book {
    private String mBookTitle;

    private String mAuthor;

    public Book(String bookTitle, String author){
        mBookTitle = bookTitle;
        mAuthor = author;
    }

    public String getBookTitle(){
        return mBookTitle;
    }

    public String getAuthor(){
        return mAuthor;
    }
}
