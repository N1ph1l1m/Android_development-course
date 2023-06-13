package com.example.androiddev_part7.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OlimpusDbOpenHelper extends SQLiteOpenHelper {
    public OlimpusDbOpenHelper(Context context) {
        super(context, ClubOlympContract.DATABASE_NAME, null, ClubOlympContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db  ) {
        String CREATE_MEMBERS_TABLE = "CREATE TABLE " + ClubOlympContract.MemberEntry.TABLE_NAME + "(" +
                ClubOlympContract.MemberEntry.KEY_ID + "INTEGER PRIMARY KEY," +
                ClubOlympContract.MemberEntry.KEY_FIRST_NAME + "TEXT," +
                ClubOlympContract.MemberEntry.KEY_LAST_NAME + "TEXT," +
                ClubOlympContract.MemberEntry.KEY_GENDER + " INTEGER NOT NULL," +
                ClubOlympContract.MemberEntry.KEY_SPORT + "TEXT " + ")";
        db.execSQL(CREATE_MEMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + ClubOlympContract.DATABASE_NAME);
        onCreate(db);
    }
}
