package com.appbuilder.truemusic.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by toon on 11/25/2017.
 */

//http://sittikiat.streetfood.in.th:1111/api/albums

public class Album {

    @SerializedName("genre_id")
    private String id;

    @SerializedName("genre_name")
    private String name;

    @SerializedName("genre_pic")
    private String picture;

}
