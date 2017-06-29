package com.example.a91256.freedomandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.adapter.ChapterAdapter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.bean.ComicImage;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.presenter.ComicChapterPresenter;

import java.util.ArrayList;

public class ComicChapterActivity extends AppCompatActivity implements BaseView {
    private final String TAG = "ComicChapterActivity";

    private RecyclerView mRecyclerView;

    private ComicChapterPresenter presenter;
    private ChapterAdapter mAdapter;

    private String chapterId;
    private ArrayList<ComicImage> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_chapter);
        Intent intent = getIntent();
        chapterId = intent.getStringExtra("chapterId");
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.chapter_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ChapterAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        presenter = new ComicChapterPresenter(this);
        presenter.loadData(chapterId);
    }

    @Override
    public void loadComplete(Object object) {
        Log.e(TAG, "loadcomplete");
        if (object instanceof ComicListBean) {
            ComicListBean comicListBean = (ComicListBean) object;
            if (comicListBean.getData() != null && comicListBean.getData().getReturnData() != null) {
                imageList = comicListBean.getData().getReturnData().getImage_list();
                mAdapter.setData(imageList);
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void loadFail() {
        Log.e(TAG, "loadFail");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

}
