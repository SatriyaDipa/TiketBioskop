package com.wkp.tiketbioskop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import polinema.ac.id.androiduistarter.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMovie;
    ArrayList<Movie> movieList = new ArrayList<>();
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
        setContentView(R.layout.activity_main);

        rvMovie = findViewById(R.id.rv_movie);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Daftar Movie");
        }

        movieList.addAll(MovieData.getListData());
        movieList();
    }

    private void movieList(){
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(movieList);
        rvMovie.setAdapter(listAdapter);
    }

    //    Membuat menu setting(pengaturan)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void handlerSetting(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,Setting.class);
        startActivity(intent);
    }
}