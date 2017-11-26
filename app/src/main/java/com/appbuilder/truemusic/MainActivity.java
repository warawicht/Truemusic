package com.appbuilder.truemusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//https://www.sitepoint.com/develop-music-streaming-android-app/

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intentDemo = new Intent(this, DemoActivity.class);
        final Intent intentHome = new Intent(this, HomeActivity.class);


        View demoScreen = findViewById(R.id.demoScreen);

        demoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDemo);
            }
        });

        View homeScreen = findViewById(R.id.homeScreen);

        homeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentHome);
            }
        });

    }


}
