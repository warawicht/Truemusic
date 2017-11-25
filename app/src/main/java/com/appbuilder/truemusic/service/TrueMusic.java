package com.appbuilder.truemusic.service;

import com.appbuilder.truemusic.config.Config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toon on 11/25/2017.
 */

public class TrueMusic {

    private static final Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(Config.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final TrueMusicService SERVICE = RETROFIT.create(TrueMusicService.class);

    public static TrueMusicService getService() {
        return SERVICE;
    }
}
