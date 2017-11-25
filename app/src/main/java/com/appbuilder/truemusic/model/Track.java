package com.appbuilder.truemusic.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by toon on 11/25/2017.
 */

public class Track {

    @SerializedName("song_id")
    private String id;

    @SerializedName("song_name")
    private String name;

    @SerializedName("song_file")
    private String streamUrl;

    @SerializedName("song_pic")
    private String artworkUrl;

    @SerializedName("artist_id")
    private String artistId;

    @SerializedName("album_id")
    private String albumId;

    @SerializedName("album_name")
    private String albumName;

    @SerializedName("album_pic")
    private String albumPicture;

    @SerializedName("genre_id")
    private String genreId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumPicture() {
        return albumPicture;
    }

    public String getGenreId() {
        return genreId;
    }
}
