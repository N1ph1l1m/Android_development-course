package com.example.androiddev_part7.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OlimpusContentProvider  extends ContentProvider {

    private static final int MEMBERS = 111;
    private static final int MEMBERS_ID = 222;

    OlimpusDbOpenHelper dbOpenHelper;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(ClubOlympContract.AUTHORITY, ClubOlympContract.PATH_MEMBERS, MEMBERS);
        uriMatcher.addURI(ClubOlympContract.AUTHORITY, ClubOlympContract.PATH_MEMBERS + "/#",MEMBERS_ID);
    }


    @Override
    public boolean onCreate() {
        dbOpenHelper = new OlimpusDbOpenHelper(getContext());
        return false;
    }


    @Override
    // content://com.android.uraall.clubolympus/members/34
    // projection = { "lastName" , "gender" }
    public Cursor query(Uri uri,  String[] projection,  String selection,  String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor;

        int match = uriMatcher.match(uri);

        switch (match){
            case MEMBERS:
                cursor = db.query(ClubOlympContract.MemberEntry.TABLE_NAME,projection,selection,selectionArgs,null ,null,sortOrder);
                break;

                // selection = "_id=?"
            // selectionArg = 34
            case MEMBERS_ID:
                selection = ClubOlympContract.MemberEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(ClubOlympContract.MemberEntry.TABLE_NAME,projection,selection,selectionArgs,null ,null,sortOrder);
                break;
            default:
                Toast.makeText(getContext(),"Incorrect URI",Toast.LENGTH_LONG).show();
                throw   new IllegalArgumentException("Can't query incorect URI " + uri);
        }
        return cursor;
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
    public String getType(Uri uri) {
        return null;
    }
}
