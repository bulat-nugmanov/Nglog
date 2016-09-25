package com.nglog.nglog_android;

import android.app.SearchManager;
import android.app.VoiceInteractor;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Adi on 2016-09-24.
 */
public class JsonParserProvider extends ContentProvider {

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public String getType(Uri uri){
        return "";
    }


    List<String> ret = new ArrayList<String>();

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {


        if (ret == null || ret.isEmpty()) {
            OkHttpClient client = new OkHttpClient();

            // YOUR URL GOES HERE
            Request request = new Request.Builder()
                    .url("https://ngLog.com/user/userid/.................")
                    .build();

            try {
                Response response = client.newCall(request).execute();

                // CONVERT RESPONSE TO STRING
                String jsonString = response.body().string();

                // CONVERT RESPONSE STRING TO JSON ARRAY
                JSONArray ja = new JSONArray(jsonString);

                // ITERATE THROUGH AND RETRIEVE CLUB FIELDS
                int n = ja.length();
                for (int i = 0; i < n; i++) {
                    // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
                    JSONObject jo = ja.getJSONObject(i);

                    // RETRIEVE EACH JSON OBJECT'S (Unit) Serial number
                    String name = jo.getString("serial");

                    // CONVERT DATA FIELDS TO CLUB OBJECT
                    ret.add(name);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        MatrixCursor cursor = new MatrixCursor(
                new String[]{
                        BaseColumns._ID,
                        SearchManager.SUGGEST_COLUMN_TEXT_1,
                        SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID
                }
        );

        if (ret != null) {
            String query = uri.getLastPathSegment().toUpperCase();
            int limit = Integer.parseInt(uri.getQueryParameter(SearchManager.SUGGEST_PARAMETER_LIMIT));

            int length = ret.size();
            for (int i = 0; i < length && cursor.getCount() < limit; i++) {
                String r = ret.get(i);
                if (r.toUpperCase().contains(query)) {
                    cursor.addRow(new Object[]{i, r, i});
                }
            }
        }
        return cursor;
    }
}
