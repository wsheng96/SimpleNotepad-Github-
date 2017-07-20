package com.inti.student.simplenotepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Load the password
        SharedPreferences settings = getSharedPreferences("PRESS", 0);
        password = settings.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")) {
                    //If there is no password


                    //For app intro
                    //If the app is start on first time it will pop out app intro,
                    // if on second or more times it will not show out
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                            boolean isFirstStart= getPrefs.getBoolean("firstStart",true);

                            if(isFirstStart){
                                startActivity(new Intent(SplashActivity.this,IntroActivity.class));
                                SharedPreferences.Editor e = getPrefs.edit();
                                e.putBoolean("firstStart",false);
                                e.apply();
                            }
                        }
                    });
                    thread.start();


                } else {
                    //If there is a password
                    Intent intent = new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }
}
