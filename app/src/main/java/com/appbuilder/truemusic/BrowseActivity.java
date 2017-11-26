package com.appbuilder.truemusic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.appbuilder.truemusic.adapter.BrowseMenuAdapter;
import com.appbuilder.truemusic.adapter.CustomOnItemClickListener;
import com.appbuilder.truemusic.adapter.FavoriteAdapter;
import com.appbuilder.truemusic.adapter.TopPlaylistAdapter;
import com.appbuilder.truemusic.adapter.TrackAdapter;
import com.appbuilder.truemusic.model.Favorite;
import com.appbuilder.truemusic.model.TopPlaylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.appbuilder.truemusic.util.BottomNavigationViewUtil.disableShiftMode;

public class BrowseActivity extends AppCompatActivity {


    private TopPlaylistAdapter topPlaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        getSupportActionBar().hide();

        BottomNavigationView bottomNavigation = findViewById(R.id.browse_bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.action_browse);
        disableShiftMode(bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Context packageContext = BrowseActivity.this;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(packageContext, HomeActivity.class));
                        finish();
                        return true;
                    case R.id.action_browse:
                        startActivity(new Intent(packageContext, BrowseActivity.class));
                        finish();
                        return true;
                    case R.id.action_live:
                        startActivity(new Intent(packageContext, LiveActivity.class));
                        finish();
                        return true;
                    case R.id.action_profile:
                        startActivity(new Intent(packageContext, ProfileActivity.class));
                        finish();
                        return true;
                    case R.id.action_search:
                        startActivity(new Intent(packageContext, SearchActivity.class));
                        finish();
                        return true;
                }
                return false;
            }
        });

        List<TopPlaylist> dummyList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            TopPlaylist dummy = new TopPlaylist();
            dummy.setImage("ic_account_circle_48pt");
            dummy.setName("Playlist" + i);
            dummy.setTag("Pop");
            dummyList.add(dummy);
        }

        topPlaylistAdapter = new TopPlaylistAdapter(this, dummyList);

        topPlaylistAdapter.setCustomOnItemClickListener(new CustomOnItemClickListener<TopPlaylist>() {
            @Override
            public void onItemClick(TopPlaylist item) {
                Toast.makeText(BrowseActivity.this, item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView favoriteRecyclerView = findViewById(R.id.browse_top_playlist_recycler_view);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        favoriteRecyclerView.setAdapter(topPlaylistAdapter);


        ListView listView = findViewById(R.id.browse_menu_list_view);

        BrowseMenuAdapter mAdapter = new BrowseMenuAdapter(this, Arrays.asList("Charts", "New Live Playlist", "New Release", "Genre", "Discover"));
        listView.setAdapter(mAdapter);

    }
}
