package com.example.cheryflix.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cheryflix.Models.Movie;
import com.example.cheryflix.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> mData;
    MovieItemClickListener movieItemClickListener;

    // 1 создали конструктор параметров
    // после добавления интерфейса - обновили конструктор
    public MovieAdapter(Context mContext, List<Movie> mData, MovieItemClickListener listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.movieItemClickListener = listener;
    }

    // 3 настраиваем какую View инфлэйтить (movie_item)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    // 5 биндим данные во ВьюХолдер
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tvTitle.setText(mData.get(i).getTitle());
        myViewHolder.imgMovie.setImageResource(mData.get(i).getThumbnail());
    }

    // 2 получаем количество данных с List`а
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 4 настраиваем какие данные помещать во ViewHolder из movie_item лэйаута
    // затем припилили каждому будушему элементу MovieItemClickListener
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView imgMovie;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.item_movie_title);
            imgMovie = itemView.findViewById(R.id.item_movie_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    movieItemClickListener.onMovieClick(mData.get(getAdapterPosition()), imgMovie);

                }
            });
        }
    }
}

