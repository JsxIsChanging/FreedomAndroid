package com.example.a91256.freedomandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.Views.TouchEventRelativeLayout;
import com.example.a91256.freedomandroid.adapter.ComicDetailListAdapter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.bean.ChapterBean;
import com.example.a91256.freedomandroid.bean.ComicDetailBean;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.bean.ReturnDataBean;
import com.example.a91256.freedomandroid.presenter.ComitDetailPresenter;
import com.example.a91256.freedomandroid.utils.ImageDownloader;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import jp.wasabeef.blurry.Blurry;


public class ComicDetailActivity extends AppCompatActivity implements BaseView, TouchEventRelativeLayout.OnComicDetailTouchListener,
        View.OnClickListener {
    private final String TAG = "ComicDetailActivity";
    static boolean loc = true;

    private ImageView headImg;
    private ImageView backgroundImg;
    private RecyclerView mRecyclerView;
    private TextView mDetailTitle;
    private TextView mDetailType;
    private TextView mDetailDes;
    private TextView mDetailAuthor;
    private TextView mHeaderTitle;
    private RelativeLayout mDetailTop;
    private TouchEventRelativeLayout mLayout;
    private RelativeLayout mHeadLayout;
    private ImageView back;
    private ImageView collect;
    private ImageView share;
    private View headerView;

    //文章ID，
    private String mComicId;
    private String url;

    private ComitDetailPresenter presenter;
    private ComicDetailListAdapter adapter;

    private ReturnDataBean mReturnDataBean;
    private ComicDetailBean mComicDetailBean;
    private ArrayList<ChapterBean> mChapterList;

    private int eventY;

    private float translateHeight;

    private boolean isLoadSuccess = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        mComicId = getIntent().getStringExtra("comicId");
        url = getIntent().getStringExtra("url");
        init();
    }

    private void init() {
        headImg = (ImageView) findViewById(R.id.head_img);
        mDetailTitle = (TextView) findViewById(R.id.detail_title);
        mDetailType = (TextView) findViewById(R.id.detail_type);
        mDetailDes = (TextView) findViewById(R.id.detail_des);
        mDetailAuthor = (TextView) findViewById(R.id.author);
        mHeaderTitle = (TextView) findViewById(R.id.header_title);
        mHeaderTitle.setVisibility(View.INVISIBLE);
        mDetailTop = (RelativeLayout) findViewById(R.id.detail_top);
        mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mLayout = (TouchEventRelativeLayout) findViewById(R.id.activity_comic_detail);

        back = (ImageView) findViewById(R.id.back);
        collect = (ImageView) findViewById(R.id.collect);
        share = (ImageView) findViewById(R.id.share);

        initListener();
        initBackGroundImg();
        initRecyclerView();
        ImageDownloader.startDownload(url, this, new BaseBitmapDataSubscriber() {
            @Override
            protected void onNewResultImpl(final Bitmap bitmap) {
                runOnUiThread(new Thread() {
                    @Override
                    public void run() {
                        headImg.setImageBitmap(bitmap);
                    }
                });
            }

            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                headImg.setImageDrawable(new BitmapDrawable());
            }
        });
        ViewCompat.setTransitionName(headImg, "image");
    }

    private void initListener() {

        back.setOnClickListener(this);
        mLayout.setOnComicDetailTouchListener(this);
    }

    private void initRecyclerView() {
        presenter = new ComitDetailPresenter(this);
        presenter.loadData(mComicId);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ComicDetailListAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }

    private void initBackGroundImg() {
        backgroundImg = (ImageView) findViewById(R.id.background_img);
        ImageDownloader.startDownload(url, this, new BaseBitmapDataSubscriber() {
            @Override
            protected void onNewResultImpl(final Bitmap bitmap) {
                runOnUiThread(new Thread() {
                    @Override
                    public void run() {
                        Blurry.with(ComicDetailActivity.this).from(bitmap).into(backgroundImg);
                    }
                });
            }

            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                backgroundImg.setImageDrawable(new BitmapDrawable());
            }
        });
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
        if (object instanceof ComicListBean) {
            ComicListBean comicListBean = (ComicListBean) object;
            if (comicListBean.getData() != null && comicListBean.getData().getReturnData() != null) {
                mReturnDataBean = comicListBean.getData().getReturnData();
                mChapterList = mReturnDataBean.getChapter_list();
                mComicDetailBean = mReturnDataBean.getComic();
                adapter.addHeaderView(headerView = createHeadView(mChapterList));
                Collections.reverse(mChapterList);
                adapter.setData(mChapterList);
                adapter.notifyDataSetChanged();

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mRecyclerView.getLayoutParams();
                if (params != null) {
//                    params.height = getWindowManager().getDefaultDisplay().getHeight() - mDetailTop.getHeight();
                    params.topMargin = (int)mHeadLayout.getY()+mHeadLayout.getHeight();
                    params.bottomMargin = - mHeadLayout.getHeight();
                    mRecyclerView.setLayoutParams(params);
                }
                mRecyclerView.setVisibility(View.VISIBLE);
                translateHeight = mHeadLayout.getHeight();

                mDetailTitle.setText(mComicDetailBean.getName());
                mHeaderTitle.setText(mComicDetailBean.getName());
                String str = "";
                for (int m = 0; m < mComicDetailBean.getTheme_ids().size() - 1; m++) {
                    str = str + mComicDetailBean.getTheme_ids().get(m) + " | ";
                }
                str += mComicDetailBean.getTheme_ids().get(mComicDetailBean.getTheme_ids().size() - 1);
                mDetailType.setText(str);
                mDetailDes.setText(mComicDetailBean.getDescription());

                mDetailAuthor.setText(mComicDetailBean.getAuthor().getName());

                isLoadSuccess = true;
            }
        }
    }

    @Override
    public void loadFail() {
        Log.e(TAG, "loadFail");
        isLoadSuccess = false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    private View createHeadView(ArrayList<ChapterBean> list) {
        View v = View.inflate(this, R.layout.comic_detail_chapterlist_header, null);
        TextView text = (TextView) v.findViewById(R.id.title);
        final CheckBox sort = (CheckBox) v.findViewById(R.id.sort);
        sort.setChecked(true);
        sort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sort.setText(ComicDetailActivity.this.getString(R.string.comic_detail_header_sort));
                } else {
                    sort.setText(ComicDetailActivity.this.getString(R.string.comic_detail_header_reverse));
                }
                reverseList();
            }
        });
        ChapterBean bean = list.get(list.size() - 1);
        int time = bean.getPass_time();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        String updateTime = simpleDateFormat.format(date);
        String title = bean.getName();
        text.setText(updateTime + "  " + this.getString(R.string.comic_detail_header) + "  " + title);
        return v;
    }

    private void reverseList() {
        Collections.reverse(mChapterList);
        adapter.setData(mChapterList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                eventY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                boolean isUsed = false;
                int y = (int) event.getY();
                float mDetailTopBottom = mDetailTop.getY() + mDetailTop.getHeight();
                if (y - eventY >= 0) {
                    if (mRecyclerView.getY() >= mDetailTopBottom && mRecyclerView.getLayoutManager().getChildAt(0).getTop() == 0) {
                        isUsed = true;
                    }
                } else {
                    if (mRecyclerView.getY() > mDetailTopBottom) {
                        isUsed = true;
                    }
                }
                eventY = y;
                return isUsed && isLoadSuccess;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                eventY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                y = (int) event.getY();
                Log.e(TAG, "move y = " + y);
                if (y - eventY >= 0) {
                    moveDown(y - eventY);
                } else {
                    moveUp(eventY - y);
                }
                eventY = y;
                break;
            case MotionEvent.ACTION_UP:
                y = (int) event.getY();
                Log.e(TAG, "move y = " + y);
                if (y - eventY >= 0) {
                    moveDown(y - eventY);
                } else {
                    moveUp(eventY - y);
                }
                eventY = -1;
                break;
        }
        return true;
    }

    private void moveUp(int length) {
        float mHeadLayoutTrans = ViewCompat.getTranslationY(mHeadLayout);
        float mRecyclerTrans = ViewCompat.getTranslationY(mRecyclerView);
        float detailBottom = mDetailTop.getY() + mDetailTop.getHeight();
        Log.e(TAG, "detailBottom = " + detailBottom);
        Log.e(TAG, "moveup length = " + length);
        float listY = mRecyclerView.getY();
        Log.e(TAG, "listy =" + listY);
        if (listY - length >= detailBottom) {
            float alpha = 1 - Math.abs(mRecyclerTrans - length) / translateHeight;
            showMoveAnimator(mHeadLayout, mHeadLayoutTrans-length, alpha, 0);
            showMoveAnimator(mRecyclerView, mRecyclerTrans-length, 1, 0);
            if(alpha <= 0.5){
                mHeaderTitle.setVisibility(View.VISIBLE);
                showMoveAnimator(mHeaderTitle,0,1 - alpha*2,0);
            }else{
                mHeaderTitle.setVisibility(View.INVISIBLE);
            }
        } else if (listY > detailBottom) {
            float translationy = mRecyclerView.getY() - mDetailTop.getY() - mDetailTop.getHeight();
            showMoveAnimator(mHeadLayout, mHeadLayoutTrans-translationy, 0, 0);
            showMoveAnimator(mRecyclerView, mRecyclerTrans-translationy, 1, 0);
        }
    }

    private void moveDown(int length) {
        float mHeadLayoutTrans = ViewCompat.getTranslationY(mHeadLayout);
        float mRecyclerTrans = ViewCompat.getTranslationY(mRecyclerView);
        float headLayoutTop = mHeadLayout.getY();
        float detailBottom = mDetailTop.getY() + mDetailTop.getHeight();
        if (headLayoutTop + length <= detailBottom) {
            float alpha = 1 - Math.abs(mRecyclerTrans - length) / translateHeight;
            showMoveAnimator(mHeadLayout, mHeadLayoutTrans + length, alpha, 0);
            showMoveAnimator(mRecyclerView,mRecyclerTrans + length, 1, 0);
            if(alpha <= 0.5){
                mHeaderTitle.setVisibility(View.VISIBLE);
                showMoveAnimator(mHeaderTitle,0,1 - alpha*2,0);
            }else{
                mHeaderTitle.setVisibility(View.INVISIBLE);
            }
        } else if (headLayoutTop < detailBottom) {
            float translationy = mDetailTop.getY() + mDetailTop.getHeight() - mHeadLayout.getY();
            showMoveAnimator(mHeadLayout, mHeadLayoutTrans + translationy, 1, 0);
            showMoveAnimator(mRecyclerView,mRecyclerTrans + translationy, 1, 0);
        }
    }

    private void showMoveAnimator(View view, float translationy, float alpha, long duration) {
        if(alpha <= 0.1)alpha = 0;
        ViewCompat.animate(view)
                .translationY(translationy)
                .alpha(alpha)
                .setDuration(duration)
                .start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
