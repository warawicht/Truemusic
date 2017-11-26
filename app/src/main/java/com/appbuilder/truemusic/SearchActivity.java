package com.appbuilder.truemusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

import com.appbuilder.truemusic.adapter.SearchAdapter;
import com.appbuilder.truemusic.model.StringDataObject;

import java.util.ArrayList;
import java.util.List;

import static com.appbuilder.truemusic.util.BottomNavigationViewUtil.disableShiftMode;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();

        BottomNavigationView bottomNavigation = findViewById(R.id.search_bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.action_search);
        disableShiftMode(bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Context packageContext = SearchActivity.this;
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

        List<StringDataObject> dummyList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            StringDataObject dummy = new StringDataObject();
            dummy.setText1("item" + i);
            dummy.setText2("ic_add_48pt");
            dummyList.add(dummy);
        }

        SearchAdapter searchAdapter = new SearchAdapter(this, dummyList);
        GridView gridView = findViewById(R.id.search_grid_view);
        gridView.setAdapter(searchAdapter);

    }
}
