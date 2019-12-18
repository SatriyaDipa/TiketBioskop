package com.wkp.tiketbioskop.activities;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

import polinema.ac.id.androiduistarter.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;

    public ListAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_design, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);
        holder.tvJudul.setText(movie.getJudul());
        holder.tvTayang.setText(movie.getTayang());
        holder.tvHarga.setText(movie.getHarga());
        holder.tvDurasi.setText(movie.getDurasi());
        holder.tvDirektor.setText(movie.getDirektor());

        holder.cvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Details.class);
                Details details = new Details();
                intent.putExtra(details.EXTRA_GAMBAR, movie.getPhoto());
                intent.putExtra(details.EXTRA_JUDUL, movie.getJudul());
                intent.putExtra(details.EXTRA_DESKRIPSI, movie.getDeskripsi());
                intent.putExtra(details.EXTRA_DIREKTOR, movie.getDirektor());
                intent.putExtra(details.EXTRA_WRITER, movie.getWriter());
                intent.putExtra(details.EXTRA_STARS, movie.getStars());
                holder.itemView.getContext().startActivity(intent);
            }
        });

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(100, 140))
                .into(holder.imgMovie);

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        CardView cvMovie;
        ImageView imgMovie;
        TextView tvJudul, tvDurasi, tvHarga, tvTayang, tvDirektor;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.img_movie);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvDurasi = itemView.findViewById(R.id.tv_durasi);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            tvTayang = itemView.findViewById(R.id.tv_tayang);
            tvDirektor = itemView.findViewById(R.id.tv_director);
            cvMovie = itemView.findViewById(R.id.cv_movie);
        }
    }
}
