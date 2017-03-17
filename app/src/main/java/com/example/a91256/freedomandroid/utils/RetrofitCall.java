package com.example.a91256.freedomandroid.utils;

import com.example.a91256.freedomandroid.bean.ComicListBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 91256 on 2017/3/15.
 */

public interface RetrofitCall {
    @GET("rank/list")
    Call<ComicListBean> getComicListCall();
}
