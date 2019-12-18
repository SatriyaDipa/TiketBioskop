package com.wkp.tiketbioskop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import polinema.ac.id.androiduistarter.R;

public class Details extends AppCompatActivity implements View.OnClickListener  {
    public String EXTRA_JUDUL = "JUDUL";
    public String EXTRA_GAMBAR = "GAMBAR";
    public String EXTRA_DESKRIPSI = "DESKRIPSI";
    public String EXTRA_DIREKTOR = "DIREKTOR";
    public String EXTRA_WRITER = "WRITER";
    public String EXTRA_STARS = "STARS";

    int total = 0;

    ImageView imgMovie;
    Button btnBuy, btnTambah, btnKurang;
    TextView tvJudul, tvDeskripsi, tvDirektor, tvWriter, tvStars, tvTampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgMovie = findViewById(R.id.img_movie);
        tvJudul = findViewById(R.id.tv_judul);
        tvDeskripsi = findViewById(R.id.deskripsi);
        tvDirektor = findViewById(R.id.tv_director);
        tvWriter = findViewById(R.id.tv_writers);
        tvStars = findViewById(R.id.tv_stars);
        btnBuy = findViewById(R.id.btnBuy);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        tvTampil = findViewById(R.id.tv_tampil);

        String judul = getIntent().getStringExtra(EXTRA_JUDUL);
        Glide.with(this).load(getIntent().getStringExtra(EXTRA_GAMBAR)).into(imgMovie);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);
        String direktor = getIntent().getStringExtra(EXTRA_DIREKTOR);
        String writer = getIntent().getStringExtra(EXTRA_WRITER);
        String stars = getIntent().getStringExtra(EXTRA_STARS);

        tvJudul.setText(judul);
        tvDeskripsi.setText(deskripsi);
        tvDirektor.setText(direktor);
        tvWriter.setText(writer);
        tvStars.setText(stars);

        btnBuy.setOnClickListener(this);
        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int hasil1 = 0;
        int hasil2 = 0;
        switch (view.getId()){
            case R.id.btnTambah:
                hasil1 = ++total;
                tvTampil.setText(String.valueOf(hasil1));
                break;
            case R.id.btnKurang:
                if (total == 0) {

                } else if (total >= 0) {
                    hasil2 = --total;
                    tvTampil.setText(String.valueOf(hasil2));
                }break;
            case R.id.btnBuy:
                if (total == 0) {
                    Toast.makeText(Details.this, "Anda belum memesan tiket", Toast.LENGTH_SHORT).show();
                } else if (total >= 0) {
                    Toast.makeText(Details.this, "Tiket telah dipesan sebanyak " + total, Toast.LENGTH_SHORT).show();
                } else if (total <= 0) {
                    Toast.makeText(Details.this, "error: tiket tidak bisa kurang dari 0!", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

}
