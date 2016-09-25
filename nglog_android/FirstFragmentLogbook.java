package com.nglog.nglog_android;


import android.app.ExpandableListActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Crow on 9/24/2016.
 */

public class FirstFragmentLogbook extends Fragment{
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout_logbook, container, false);
        return myView;




    }


}

