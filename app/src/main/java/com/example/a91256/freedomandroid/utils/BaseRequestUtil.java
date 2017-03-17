package com.example.a91256.freedomandroid.utils;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 91256 on 2017/3/15.
 */

public class BaseRequestUtil {
    public static <T> T createApe(Class<T> clazz){
        return createApi(clazz,Urls.MAIN_URL);
    }

    public static <T> T createApi(Class<T> clazz,String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
