package com.example.androiddev_part7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androiddev_part7.data.ClubOlympContract;
import com.example.androiddev_part7.data.OlimpusContentProvider;


import java.net.URI;
import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText sportEditText;
    private Spinner genderSpinner;
    private int gender = 0;
    private ArrayAdapter spinnerAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_member,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_member:
                insertMember();
                return  true;
            case R.id.delete_member:
                return  true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return  super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        firstNameEditText = findViewById(R.id.editFirstName);
        lastNameEditText = findViewById(R.id.editLastName);
        genderSpinner = findViewById(R.id.spinnerGender);
        sportEditText= findViewById(R.id.sportEditText);



        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_gender, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(spinnerAdapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seletedGender = (String) parent.getItemAtPosition(position);
                if(!TextUtils.isEmpty(seletedGender)){
                    if(seletedGender.equals("Male")){
                        gender = ClubOlympContract.MemberEntry.GENDER_MALE;
                    }else if (seletedGender.equals("Female")){
                        gender = ClubOlympContract.MemberEntry.GENDER_FEMALE;
                    }else{
                        gender= ClubOlympContract.MemberEntry.GENDER_UNKNOWN;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
         gender = 0;
            }
        });

    }
    private void insertMember() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName  = lastNameEditText.getText().toString().trim();
        String sport = sportEditText.getText().toString().trim();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ClubOlympContract.MemberEntry.KEY_FIRST_NAME,firstName);
        contentValues.put(ClubOlympContract.MemberEntry.KEY_LAST_NAME,lastName);
        contentValues.put(ClubOlympContract.MemberEntry.KEY_SPORT,sport);
        contentValues.put(ClubOlympContract.MemberEntry.KEY_GENDER,gender);

        ContentResolver contentResolver  = getContentResolver();
        Uri uri = contentResolver.insert(ClubOlympContract.MemberEntry.CONTENT_URI,contentValues);

        if(uri == null){
            Toast.makeText(this,"Insertion of data in the table failed for", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Data seved", Toast.LENGTH_LONG).show();
        }


    }
}