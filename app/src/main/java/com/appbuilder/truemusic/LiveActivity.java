package com.appbuilder.truemusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.appbuilder.truemusic.adapter.ChatAdapter;
import com.appbuilder.truemusic.model.Chat;

import java.util.ArrayList;
import java.util.List;

import static com.appbuilder.truemusic.util.BottomNavigationViewUtil.disableShiftMode;

public class LiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        getSupportActionBar().hide();

        BottomNavigationView bottomNavigation = findViewById(R.id.live_bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.action_live);
        disableShiftMode(bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Context packageContext = LiveActivity.this;
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


        List<Chat> dummyList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Chat dummy = new Chat();
            dummy.setName("User" + i);
            dummy.setTime( (11 - i) + " mins ago");
            dummy.setMessage("Hello World " + i);
            dummyList.add(dummy);
        }

        ChatAdapter chatAdapter = new ChatAdapter(this, dummyList);

        ListView listView = findViewById(R.id.live_chat_list_view);
        listView.setAdapter(chatAdapter);
        listView.setFocusable(false);
    }
}
