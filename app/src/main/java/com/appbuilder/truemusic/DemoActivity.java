package com.appbuilder.truemusic;

import android.media.AudioManager;
import android.media.MediaPlayer;
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

public class DemoActivity extends AppCompatActivity {

    private static final String TAG = "DemoActivity";

    private List<Track> mListItems;
    private TrackAdapter mAdapter;

    private TextView mSelectedTrackTitle;
    private ImageView mSelectedTrackImage;

    private MediaPlayer mMediaPlayer;
    private ImageView mPlayerControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        getSupportActionBar().hide();

        mListItems = new ArrayList<>();
        ListView listView = findViewById(R.id.track_list_view);

        mAdapter = new TrackAdapter(this, mListItems);
        listView.setAdapter(mAdapter);

        TrueMusicService service = TrueMusic.getService();
        service.getTracks(1).enqueue(new Callback<List<Track>>() {

            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if (response.isSuccessful()) {
                    List<Track> tracks = response.body();
                    loadTracks(tracks);
                } else {
                    Log.e(TAG, "Error code " + response.code());
                    showMessage("Error code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                Log.e(TAG, "Network Error: " + t.getMessage());
                showMessage("Network Error: " + t.getMessage());
            }
        });

        mSelectedTrackTitle = findViewById(R.id.selected_track_title);
        mSelectedTrackImage = findViewById(R.id.selected_track_image);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Track track = mListItems.get(position);

                mSelectedTrackTitle.setText(track.getName());
                Picasso.with(DemoActivity.this).load(track.getAlbumPicture()).into(mSelectedTrackImage);

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                    mMediaPlayer.reset();
                }

                try {

                    String streamUrl = encodeUrl(track.getStreamUrl());
                    Log.d(TAG, "StreamUrl: " + streamUrl);
                    mMediaPlayer.setDataSource(streamUrl);
                    mMediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }


            }
        });

        mPlayerControl = findViewById(R.id.player_control);

        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                togglePlayPause();
            }
        });

        mPlayerControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause();
            }
        });

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayerControl.setImageResource(R.drawable.ic_play);
            }
        });

    }

    private void loadTracks(List<Track> tracks) {
        mListItems.clear();
        mListItems.addAll(tracks);
        mAdapter.notifyDataSetChanged();
    }

    private void showMessage(String message) {
        Toast.makeText(DemoActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void togglePlayPause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mPlayerControl.setImageResource(R.drawable.ic_play);
            Log.d(TAG, "mMediaPlayer.pause()");
        } else {
            mMediaPlayer.start();
            mPlayerControl.setImageResource(R.drawable.ic_pause);
            Log.d(TAG, "mMediaPlayer.start()");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private String encodeUrl(String raw) throws URISyntaxException, MalformedURLException {
        String urlStr = raw;
        URL url = new URL(urlStr);
        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        url = uri.toURL();
        return url.toExternalForm();
    }
}
