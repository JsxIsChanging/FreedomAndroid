package com.example.a91256.freedomandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.Views.AutoChannelView;
import com.example.a91256.freedomandroid.Views.AutoChannelView.OnChannelSelectedListener;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.bean.RankinglistBean;
import com.example.a91256.freedomandroid.presenter.ComicListPresenter;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/3/27.
 */

public class ComicListFragment extends Fragment implements BaseView,OnChannelSelectedListener{

    private AutoChannelView mChannelView;
    private ComicListPresenter mComicListPresenter;
    private ComicListBean mComitList;
    private ArrayList<RankinglistBean> mRankList = new ArrayList<>();
    private ViewPager mPager;
    private FragmentPagerAdapter mPagerAdapter;
    private FragmentManager mFragmentManager;

    public ComicListFragment() {
        super();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View coverView =  inflater.inflate(R.layout.comiclist_layout,container,false);
        mChannelView = (AutoChannelView)coverView.findViewById(R.id.titles);
        mPager = (ViewPager)coverView.findViewById(R.id.content_list);
        mChannelView.init(this);
        mComicListPresenter = new ComicListPresenter(this);
        mComicListPresenter.loadData();
        return coverView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadComplete(Object object) {
        if(object instanceof ComicListBean){
            mComitList = (ComicListBean)object;
            mRankList = mComitList.getData().getReturnData().getRankinglist();
            mChannelView.setChannel(mRankList);
            initPager();
        }
    }
    private void initPager(){
        if(mFragmentManager == null){
            mFragmentManager = this.getFragmentManager();
        }
        if(mPagerAdapter == null){
            mPagerAdapter = new FragmentPagerAdapter(mFragmentManager) {
                @Override
                public Fragment getItem(int position) {
                    return ComicRankDetailFragment.getInstance(mRankList.get(position));
                }

                @Override
                public int getCount() {
                    return mRankList.size();
                }
            };
        }
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mChannelView.changeChannel(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedposition);
            }
        });

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

    @Override
    public void onChannelSelected(int position) {
        mPager.setCurrentItem(position,true);
    }

}
