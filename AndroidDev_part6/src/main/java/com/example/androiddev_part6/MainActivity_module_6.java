package com.example.androiddev_part6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity_module_6 extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_module6);
//        simpleCountDownTimer
//        simpleHandler();
//        SharedPreferencesFunc();




//          for function onSave--
        /*
        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString("textToBundle"));
        }

        textView = findViewById(R.id.textView);
        Log.d("LifeStyle method","onCreate();");
        textView.append("onCreate();"+"\n");*/
    }
    //Таймер обратного отчета - таймер длится 10 секунд, с интервалом в одну секунду
    public void simpleCountDownTimer(){

        CountDownTimer firstTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("Timer",String.valueOf(millisUntilFinished/1000) +
                        "   seconds left.");
            }

            @Override
            public void onFinish() {
                Log.d("Timer", "Finish");
            }
        };
        firstTimer.start();
    }

    // Простой таймер
    public void simpleHandler(){
        Handler  handler =  new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("Runnable:","Two second are passed");
                handler.postDelayed(this,2000);
            }
        };
        handler.post(runnable);

    }
    //Сохранение данных через функцию  SharedPreferences
    public void SharedPreferencesFunc(){
//        SharedPreferences sharedPreferences = this.getSharedPreferences("firstPref", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("newPref","Advansed text");
//        //Очищает данные ключ-значение
//        //editor.clear();
//        editor.apply();
//
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(sharedPreferences.getString("newPref","Simple  text"));
    }

    // Обычное сохранение данных
    public void onSAVE(){

//        @Override
//        protected void onStart() {
//            super.onStart();
//
//            Log.d("LifeStyle method","onStart();");
//            //textView.append("onStart();"+"\n");
//        }
//
//        @Override
//        protected void onResume() {
//            super.onResume();
//
//            Log.d("LifeStyle method","onResume();");
//            //textView.append("onResume();"+"\n");
//        }
//
//        @Override
//        protected void onPause() {
//            super.onPause();
//
//            Log.d("LifeStyle method","onPause();");
//            //textView.append("onPause();"+"\n");
//        }
//
//        @Override
//        protected void onStop() {
//            super.onStop();
//
//            Log.d("LifeStyle method","onStop();");
//            //textView.append("onStop);"+"\n");
//        }
//
//        @Override
//        protected void onDestroy() {
//            super.onDestroy();
//
//            Log.d("LifeStyle method","onDestroy();");
//            //textView.append("onDestroy();"+"\n");
//        }

        //Сохраняет состояние activity по ключу  textToBundle.Сохраняет данные только в одной сесси пользователя.
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        Log.d("LifeStyle method","onSaveInstanceState();");
//        //textView.append("onSaveInstanceState();"+"\n");
//
//        outState.putString("textToBundle", textView.getText().toString());
//    }
    }


}