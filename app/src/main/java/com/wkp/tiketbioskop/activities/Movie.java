package com.wkp.tiketbioskop.activities;

public class Movie {
    private String judul;
    private String durasi;
    private String harga;
    private String photo;
    private String deskripsi;
    private String direktor;
    private String writer;
    private String stars;

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDirektor() {
        return direktor;
    }

    public void setDirektor(String direktor) {
        this.direktor = direktor;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTayang() {
        return tayang;
    }

    public void setTayang(String tayang) {
        this.tayang = tayang;
    }

    private String tayang;
}
