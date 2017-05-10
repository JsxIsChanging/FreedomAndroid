package com.example.a91256.freedomandroid.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.base.BaseView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class ComicDetailActivity extends AppCompatActivity implements BaseView {
    private final String TAG = "ComicDetailActivity";
    static boolean loc = true;

    private ImageView headImg;

    private String mComicId;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        mComicId = getIntent().getStringExtra("comicId");
        url = getIntent().getStringExtra("url");
        init();
    }

    private void init() {
//        headImg = (SimpleDraweeView)findViewById(R.id.head_img);
        headImg = (ImageView) findViewById(R.id.head_img);
//        headImg.setImageURI(url);
        Picasso.with(this).load(url).into(headImg);
        ViewCompat.setTransitionName(headImg, "image");
    }

    public static void launch(Activity activity, View view, String comicId, String url) {
        Intent intent = new Intent(activity, ComicDetailActivity.class);
        intent.putExtra("comicId", comicId);
        intent.putExtra("url", url);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, view, "image");

        ActivityCompat.startActivity(activity, intent, options.toBundle());
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
