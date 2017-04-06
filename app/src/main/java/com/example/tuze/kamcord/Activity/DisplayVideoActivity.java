package com.example.tuze.kamcord.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.tuze.kamcord.Constants.AppConstants;
import com.example.tuze.kamcord.Model.Card;
import com.example.tuze.kamcord.R;
import com.example.tuze.kamcord.Util.NetworkUtil;
import com.plattysoft.leonids.ParticleSystem;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayVideoActivity extends Activity implements View.OnClickListener, Runnable {

    @BindView(R.id.vvVideo)
    VideoView vvVideo;
    @BindView(R.id.btnLike)
    FloatingActionButton btnLike;
    @BindView(R.id.btnProfile)
    FloatingActionButton btnProfile;
    @BindView(R.id.btnShare)
    FloatingActionButton btnShare;
    @BindView(R.id.tvLikeCount)
    TextView tvLikeCount;
    private Card card;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.activity_display_video)
    RelativeLayout layout;
    private Handler progressHandler = new Handler();
    private int progressCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video);
        ButterKnife.bind(this);

        card = (Card) Parcels.unwrap(getIntent().getParcelableExtra(AppConstants.CARD));

        setViewValues();
        setListeners();

        if(NetworkUtil.isNetworkAvailable(this)) {
            vvVideo.setVisibility(View.VISIBLE);
            vvVideo.start();
            new Thread(this).start();
        }

    }

    private void setListeners(){
        //Add listeners
        //Endless play video
        vvVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer vmp) {
                if(NetworkUtil.isNetworkAvailable(DisplayVideoActivity.this)) {
                    vvVideo.setVisibility(View.VISIBLE);
                    vvVideo.start();
                    progressCount = 0;
                    new Thread(DisplayVideoActivity.this).start();
                }
            }
        });

        //St buttons listeners
        btnLike.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnShare.setOnClickListener(this);
    }

    private void setViewValues() {
        vvVideo.setVideoPath(card.getShotCardData().getPlay().getMp4());
        tvLikeCount.setText(card.getShotCardData().getHeartCount().toString());
        layout.setBackgroundColor(Color.parseColor(card.getShotCardData().getColor()));
        progressBar.setMax(100);
        progressBar.setProgress(progressCount);
    }


    //Run progressbar
    @Override
    public void run() {
        while (progressCount < 100 * card.getShotCardData().getDuration()) {
            // Update the progress status
            progressCount += 1;

            // Try to sleep the thread for 20 milliseconds
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Update the progress bar
            progressHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(progressCount);
                }
            });
        }
    }

    @Override
    public void onClick(View view) {

        //Particle System class belongs to third party library (http://plattysoft.github.io/Leonids/)
        int id = view.getId();
        if (id == R.id.btnLike) {
            new ParticleSystem(this, 80, R.drawable.like, 10000)
                    .setSpeedRange(0.2f, 0.5f)
                    .oneShot(btnLike, 20);
        } else if (id == R.id.btnProfile) {
            new ParticleSystem(this, 80, R.drawable.emoticon, 10000)
                    .setSpeedRange(0.2f, 0.5f)
                    .oneShot(btnProfile, 20);
        } else if (id == R.id.btnShare) {
            new ParticleSystem(this, 80, R.drawable.plane, 10000)
                    .setSpeedRange(0.2f, 0.5f)
                    .oneShot(btnShare, 20);
        }

    }
}


