package com.example.androiddev_part7.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OlimpusContentProvider  extends ContentProvider {

    OlimpusDbOpenHelper dbOpenHelper;

    @Override
    public boolean onCreate() {
        dbOpenHelper = new OlimpusDbOpenHelper(getContext());
        return false;
    }


    @Override
    public Cursor query(@NonNull Uri uri,  String[] strings,  String s,  String[] strings1, String s1) {
        return null;
    }

    @Override
    public Uri insert( Uri uri,  ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete( Uri uri, String s,  String[] strings) {
        return 0;
    }

    @Override
    public int update( Uri uri,  ContentValues contentValues,  String s,  String[] strings) {
        return 0;
    }
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
}
