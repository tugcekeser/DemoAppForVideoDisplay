package com.example.tuze.kamcord.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.tuze.kamcord.Model.Card;
import com.example.tuze.kamcord.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> cardList;
    private Context context;

    public VideoAdapter(Context context, List<Card> cardList) {
        this.cardList = cardList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        View viewVideo = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_image_item, parent, false);
        viewHolder = new VideoViewHolder(viewVideo, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Card card = cardList.get(position);

        if (card != null) {
            VideoViewHolder vhVideo = (VideoViewHolder) holder;

            if (card.getShotCardData().getShotThumbnail() != null)
                vhVideo.setVideoImage(card.getShotCardData().getShotThumbnail().getLarge(), card);
        }
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
