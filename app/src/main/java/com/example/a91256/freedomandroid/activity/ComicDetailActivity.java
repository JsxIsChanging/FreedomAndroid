package com.example.a91256.freedomandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.a91256.freedomandroid.base.BaseView;

/**
 * Created by 91256 on 2017/5/3.
 */

public class ComicDetailActivity extends Activity implements BaseView {

    private String comicId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comicId = getIntent().getStringExtra("comicId");
    }

    @Override
    public void loadComplete(Object object) {

    }

    @Override
    public void loadFail() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }
}
