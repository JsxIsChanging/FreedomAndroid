package com.example.a91256.freedomandroid.base;

/**
 * Created by 91256 on 2017/3/13.
 */

public interface BaseView {
    /***
     *下载成功
     */
    void loadComplete(Object object);
    /***
     *下载失败
     */
    void loadFail();
    /***
     *显示下载UI
     */
    void showLoading();
    /***
     *隐藏下载UI
     */
    void stopLoading();
}
