package com.nglog.nglog_android;

import android.app.Dialog;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class Page3main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText nameTxt, phoneTxt, emailTxt, addressTxt;
    List<Contact> Contacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //add new contact:--------------------------------------------------
        setContentView(R.layout.activity_page3main);
        nameTxt = (EditText) findViewById(R.id.txtName);
        phoneTxt = (EditText) findViewById(R.id.txtPhone);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        addressTxt = (EditText) findViewById(R.id.txtAddress);

        //define tabs for from add contact tabs
        TabHost tabHost;
        //tabHost.setup();
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();


        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tabAddContact);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);

        final LinearLayout contlist = (LinearLayout) findViewById(R.id.contlist);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contlist.addView(createNewButtonView(nameTxt.getText().toString()));


                Toast.makeText(getApplicationContext(), "Contact Created!", Toast.LENGTH_SHORT).show();
            }
        });

        //What happens on :
        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                //check if there was input in the text
                addBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //-------------------------------------------------------------------


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private TextView createNewTextView(String text) {
        final TextView textView = new TextView(this);
        textView.setText(text);
        return textView;
    }

    private Button createNewButtonView(String text) {
        final Button button = new Button(this);
        button.setText(text);
        return button;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter() {
            super(Page3main.this, R.layout.second_layout_contacts, Contacts);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.page3main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_logbook) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new FirstFragmentLogbook()).commit();
        } else if (id == R.id.nav_contacts) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new SecondFragmentContacts()).commit();
        } else if (id == R.id.nav_map) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ThirdFragmentMap()).commit();
        } else if (id == R.id.nav_site_info) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
