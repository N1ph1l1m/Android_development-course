package com.example.androiddev_part7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.androiddev_part7.data.ClubOlympContract;



import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText groupNameEditText;
    private Spinner genderSpinner;
    private int     gender = 0;
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
        groupNameEditText = findViewById(R.id.groupNameEdit);



        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_gender, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(spinnerAdapter);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
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
}