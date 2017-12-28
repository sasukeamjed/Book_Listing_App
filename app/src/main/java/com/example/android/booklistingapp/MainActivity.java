package com.example.android.booklistingapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    public static final String LOG_TAG = MainActivity.class.getName();

    private static String REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=";



    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int BOOK_LOADER_ID = 1;

    private BookAdapter mAdapter;

    private EditText searchInput;

    private TextView messageToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView bookListView = (ListView) findViewById(R.id.list);

        searchInput = findViewById(R.id.search_edit_text);

        final String searchResults = searchInput.getText().toString();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                REQUEST_URL = REQUEST_URL + searchResults;

                mAdapter = new BookAdapter(MainActivity.this, new ArrayList<Book>());

                bookListView.setAdapter(mAdapter);

                // Get a reference to the LoaderManager, in order to interact with loaders.
                LoaderManager loaderManager = getLoaderManager();


                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                // because this activity implements the LoaderCallbacks interface).

                loaderManager.initLoader(BOOK_LOADER_ID, null, MainActivity.this);





            }

        });









    }

    public String getSearchInput( ) {
        return searchInput.getText().toString().trim();
    }

    public void displayMessage(String reminderText ) {
        messageToDisplay.setText(reminderText);
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
        mAdapter.clear();
        return new BookLoader(this, REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {


        if (books == null){
            return;
        }

        mAdapter.clear();
        mAdapter.addAll(books);
        mAdapter.notifyDataSetChanged();



    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        mAdapter.clear();
    }





}



