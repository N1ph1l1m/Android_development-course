  package com.example.androiddev_part7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androiddev_part7.data.ClubOlympContract;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

  public class MainActivity extends AppCompatActivity {

      TextView dataTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataTextView = findViewById(R.id.dataTextWiew);


        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddMemberActivity.class);
                startActivity(intent);
            }

        });


    }
    protected  void onStart(){
        super.onStart();
        displayData();
    }
    private  void displayData() {
        String[] projection = {
                ClubOlympContract.MemberEntry._ID,
                ClubOlympContract.MemberEntry.KEY_FIRST_NAME,
                ClubOlympContract.MemberEntry.KEY_LAST_NAME,
                ClubOlympContract.MemberEntry.KEY_GENDER,
                ClubOlympContract.MemberEntry.KEY_SPORT
        };

        Cursor cursor = getContentResolver().query(ClubOlympContract.MemberEntry.CONTENT_URI,
                projection,
                null,
                null,
                null
        );
        dataTextView.setText("All member \n\n");
        dataTextView.append(ClubOlympContract.MemberEntry._ID + " " +
                ClubOlympContract.MemberEntry.KEY_FIRST_NAME + " " +
                ClubOlympContract.MemberEntry.KEY_LAST_NAME + " " +
                ClubOlympContract.MemberEntry.KEY_GENDER + " " +
                ClubOlympContract.MemberEntry.KEY_SPORT);

        int idIndex = cursor.getColumnIndex(ClubOlympContract.MemberEntry._ID);
        int  idFirstName= cursor.getColumnIndex(ClubOlympContract.MemberEntry.KEY_FIRST_NAME);
        int idLastName = cursor.getColumnIndex(ClubOlympContract.MemberEntry.KEY_LAST_NAME);
        int idGender = cursor.getColumnIndex(ClubOlympContract.MemberEntry.KEY_GENDER);
        int idSport = cursor.getColumnIndex(ClubOlympContract.MemberEntry.KEY_SPORT);

        while (cursor.moveToNext()){
            int currentId = cursor.getInt(idIndex);
            String currentFirstName = cursor.getString(idFirstName);
            String currentLastName = cursor.getString(idLastName);
            int currentGender = cursor.getInt(idGender);
            String currentSport = cursor.getString(idSport);

            dataTextView.append("\n" +
                    currentId + " "+
                    currentFirstName + " " +
                    currentLastName + " " +
                    currentGender + " " +
                    currentSport  +  " " );
        }
        cursor.close();
    }
}