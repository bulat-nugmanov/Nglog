package com.nglog.nglog_android;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adi on 2016-09-24.
 */
public class SearchActivity extends AppCompatActivity {
    //this is for the live update search -> implements SearchView.OnQueryTextListener
    final List<String> searchList = new ArrayList<String>();   //list of serialnumbers/Location

    private Button searchbutton;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

         Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
         setSupportActionBar(my_toolbar);
         getSupportActionBar().setTitle(R.string.my_tb_title);

        ListView listView_main = (ListView) findViewById(R.id.listView_main);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.serials));
        listView_main.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        /*SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);*/


        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));



       /* MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchActivity.class)));
        searchView.setIconifiedByDefault(false);*/

        //return true;
        return super.onCreateOptionsMenu(menu);
    }

  /*  @Override
    //on choosing an option from dropdown list
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        return false;
    }

    //as you type it changes
    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        return false;
    }*/

/*    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, "Searching by: "+ query, Toast.LENGTH_SHORT).show();

        } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            String uri = intent.getDataString();
            Toast.makeText(this, "Suggestion: "+ uri, Toast.LENGTH_SHORT).show();
        }
    }*/




}


