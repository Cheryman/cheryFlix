package com.example.cheryflix.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cheryflix.Models.Cast;
import com.example.cheryflix.R;

import java.util.List;


public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private Context mContext;
    private List<Cast> castDataList;

    public CastAdapter(Context mContext, List castDataList) {
        this.mContext = mContext;
        this.castDataList = castDataList;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.cast_item, viewGroup, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder castViewHolder, int i) {
        //castViewHolder.imgCast.setImageResource(castDataList.get(i).getImgLink());
        Glide.with(mContext).load(castDataList.get(i).getImgLink()).into(castViewHolder.imgCast);

    }

    @Override
    public int getItemCount() {
        return castDataList.size();
    }


    public class CastViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCast;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCast = itemView.findViewById(R.id.img_cast);
        }
    }
}
