package com.example.a91256.freedomandroid.utils;

import com.example.a91256.freedomandroid.bean.ComicListBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 91256 on 2017/3/15.
 */

public interface RetrofitApi {
    @GET("rank/list")
    Call<ComicListBean> getComicListCall();

    @GET("rank/list")
    Observable<ComicListBean> getComicListObservable();

    @GET("list/commonComicList")
    Call<ComicListBean> getRankDetilCall(
            @Query("page")int page,
            @Query("argName")String argName,
            @Query("argValue")String value
    );
    @GET("comic/detail_static_new")
    Call<ComicListBean> getComicDetailCall(
            @Query("comicid")String comicid
    );
}
