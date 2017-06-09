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
    //排行：月票、点击等
    @GET("rank/list")
    Call<ComicListBean> getComicListCall();

    @GET("rank/list")
    Observable<ComicListBean> getComicListObservable();

    //排行信息
    @GET("list/commonComicList")
    Call<ComicListBean> getRankDetilCall(
            @Query("page")int page,
            @Query("argName")String argName,
            @Query("argValue")String value
    );
    //漫画章节列表
    @GET("comic/detail_static_new")
    Call<ComicListBean> getComicDetailCall(
            @Query("comicid")String comicid
    );
    @GET("comic/detail_static_new")
    Observable<ComicListBean> getComicDetailObservable(
            @Query("comicid")String comicid
    );
    //单节漫画详情
    @GET("comic/chapterNew")
    Call<ComicListBean> getComicChapterCall(
            @Query("chapter_id")String comicid
    );
    @GET("comic/chapterNew")
    Observable<ComicListBean> getComicChapterObservable(
            @Query("chapter_id")String comicid
    );
}
