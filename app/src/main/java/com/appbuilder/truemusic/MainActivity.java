package com.appbuilder.truemusic;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appbuilder.truemusic.adapter.TrackAdapter;
import com.appbuilder.truemusic.model.Track;
import com.appbuilder.truemusic.service.TrueMusic;
import com.appbuilder.truemusic.service.TrueMusicService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
