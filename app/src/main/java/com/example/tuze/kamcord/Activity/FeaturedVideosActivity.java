package com.example.tuze.kamcord.Activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.tuze.kamcord.Adapter.VideoAdapter;
import com.example.tuze.kamcord.Constants.AppConstants;
import com.example.tuze.kamcord.Model.Card;
import com.example.tuze.kamcord.Model.Media;
import com.example.tuze.kamcord.Network.APIClient;
import com.example.tuze.kamcord.R;
import com.example.tuze.kamcord.Util.EndlessRecyclerViewScrollListener;
import com.example.tuze.kamcord.Util.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FeaturedVideosActivity extends AppCompatActivity {

    private APIClient client;
    @BindView(R.id.rvVideos)
    RecyclerView rvVideos;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private VideoAdapter adapter;
    private Media media;
    private static List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_videos);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        setViews();

        client = new APIClient();
        cards = new ArrayList<Card>();
        adapter = new VideoAdapter(FeaturedVideosActivity.this, cards);
        rvVideos.setAdapter(adapter);

        //Loading first page
        if (cards.size() == 0)
            fetchVideos(AppConstants.FIRST_PAGE);

    }

    private void setViews() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(FeaturedVideosActivity.this, getColumnNumber());
        rvVideos.setLayoutManager(gridLayoutManager);

        //Fetch next pages / Pagination
        rvVideos.addOnScrollListener(new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                fetchVideos(media.getNextPage());
            }
        });

        //Refresh the screen
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cards.clear();
                adapter.notifyDataSetChanged();
                fetchVideos(AppConstants.FIRST_PAGE);
            }
        });

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(R.color.colorAccent);
    }


    //Calculate the columns according to screen width
    private int getColumnNumber() {
        if(isTablet(FeaturedVideosActivity.this))
            return 5;
        else
            return 3;

    }

    //Check emulator is tablet or not
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    //Fetch data from the server
    private void fetchVideos(String page) {
        swipeContainer.setRefreshing(false);

        //Network connection check
        if (NetworkUtil.isConnected(FeaturedVideosActivity.this)) {

            //Call OKHttp Client
            client.getClient(page, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(final Call call, final Response response) throws IOException {

                    if (NetworkUtil.isOnline()) {
                        final String responseData = response.body().string();

                        // Run view-related code back on the main thread
                        FeaturedVideosActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject json = new JSONObject(responseData);
                                    media = new Media(json);
                                    cards.addAll(media.getCards());
                                    adapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}