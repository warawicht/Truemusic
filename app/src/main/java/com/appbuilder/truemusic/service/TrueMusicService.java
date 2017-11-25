package com.appbuilder.truemusic.service;

import com.appbuilder.truemusic.model.Album;
import com.appbuilder.truemusic.model.Genre;
import com.appbuilder.truemusic.model.Track;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by toon on 11/25/2017.
 */

public interface TrueMusicService {

    @GET("/api/albums")
    Call<List<Album>> getAllAlbums();

    @GET("/api/genres")
    Call<List<Genre>> getAllGenres();

    @GET("/api/album/{Id}")
    Call<List<Track>> getTracks(@Path("Id") long trackId);

}
