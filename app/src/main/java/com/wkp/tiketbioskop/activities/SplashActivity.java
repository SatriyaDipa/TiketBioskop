package com.wkp.tiketbioskop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import polinema.ac.id.androiduistarter.R;

public class SplashActivity extends AppCompatActivity {
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if (sharedPref.loadNighModeState()==true){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
            }
        }, 3000);
    }

    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),Setting.class);
        startActivity(i);
        finish();
    }
}
