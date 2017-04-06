package com.example.tuze.kamcord.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tuze.kamcord.Activity.DisplayVideoActivity;
import com.example.tuze.kamcord.Constants.AppConstants;
import com.example.tuze.kamcord.Model.Card;
import com.example.tuze.kamcord.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VideoViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivVideoImage)
    ImageView ivVideoImage;
    Context context;

    public VideoViewHolder(View v, Context context) {
        super(v);
        ButterKnife.bind(this, v);
        this.context = context;
    }

    public void setVideoImage(String url, final Card card) {

        Glide.with(context)
                .load(url)
                .into(ivVideoImage);

        ivVideoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayVideoActivity.class).putExtra(AppConstants.CARD, Parcels.wrap(card));
                context.startActivity(intent);
            }
        });
    }

}
