package com.example.androiddev_part6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity_module_6 extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_module6);

        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString("textToBundle"));
        }

        textView = findViewById(R.id.textView);
        Log.d("LifeStyle method","onCreate();");
        textView.append("onCreate();"+"\n");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("LifeStyle method","onStart();");
        textView.append("onStart();"+"\n");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LifeStyle method","onResume();");
        textView.append("onResume();"+"\n");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("LifeStyle method","onPause();");
        textView.append("onPause();"+"\n");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("LifeStyle method","onStop();");
        textView.append("onStop);"+"\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("LifeStyle method","onDestroy();");
        textView.append("onDestroy();"+"\n");
    }

    //Сохраняет состояние activity по ключу  textToBundle.Сохраняет данные только в одной сесси пользователя.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("LifeStyle method","onSaveInstanceState();");
        textView.append("onSaveInstanceState();"+"\n");

        outState.putString("textToBundle", textView.getText().toString());
    }
}