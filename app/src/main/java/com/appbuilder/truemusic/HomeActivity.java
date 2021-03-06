package com.appbuilder.truemusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.appbuilder.truemusic.adapter.CustomOnItemClickListener;
import com.appbuilder.truemusic.adapter.FavoriteAdapter;
import com.appbuilder.truemusic.adapter.LiveAdapter;
import com.appbuilder.truemusic.model.Favorite;
import com.appbuilder.truemusic.model.Live;

import java.util.ArrayList;
import java.util.List;

import static com.appbuilder.truemusic.util.BottomNavigationViewUtil.disableShiftMode;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    private FavoriteAdapter favoriteAdapter;
    private LiveAdapter liveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        BottomNavigationView bottomNavigation = findViewById(R.id.home_bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.action_home);
        disableShiftMode(bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Context packageContext = HomeActivity.this;
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

        List<Favorite> dummyFavoriteList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Favorite dummy = new Favorite();
            dummy.setImage("ic_account_circle_48pt");
            dummy.setName("dummy" + i);
            dummy.setTag("Pop");
            dummyFavoriteList.add(dummy);
        }

        favoriteAdapter = new FavoriteAdapter(this, dummyFavoriteList);

        favoriteAdapter.setCustomOnItemClickListener(new CustomOnItemClickListener<Favorite>() {
            @Override
            public void onItemClick(Favorite item) {
                Toast.makeText(HomeActivity.this, item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView favoriteRecyclerView = findViewById(R.id.home_favorite_recycler_view);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        favoriteRecyclerView.setAdapter(favoriteAdapter);


        List<Live> dummyLiveList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Live dummy = new Live();
            dummy.setImage("ic_home_48pt");
            dummy.setName("yummy" + i);
            dummy.setTag("Pop");
            dummyLiveList.add(dummy);
        }

        liveAdapter = new LiveAdapter(this, dummyLiveList);

        liveAdapter.setCustomOnItemClickListener(new CustomOnItemClickListener<Live>() {
            @Override
            public void onItemClick(Live item) {
                Toast.makeText(HomeActivity.this, item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView liveRecyclerView = findViewById(R.id.home_live_recycler_view);
        liveRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        liveRecyclerView.setAdapter(liveAdapter);


    }
}
