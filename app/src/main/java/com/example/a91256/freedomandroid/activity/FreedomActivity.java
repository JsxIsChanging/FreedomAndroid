package com.example.a91256.freedomandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.fragment.ComicListFragment;
import com.example.a91256.freedomandroid.fragment.FeaturedFragment;

import java.util.ArrayList;

public class FreedomActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioButton bookcase;
    private RadioButton library;
    private RadioButton featured;
    private RadioButton find;
    private RadioGroup bottomBar;
    private FragmentManager mFragmentManager;
    private ComicListFragment mComicListFragment;
    private FeaturedFragment mFeaturedFragment;
    private FragmentTransaction mTransaction;
    private Fragment mCurrentFragment;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freedom);
        init();
    }
    private void init(){
        bookcase = (RadioButton)findViewById(R.id.bookcase_text);
        library = (RadioButton)findViewById(R.id.library_text);
        featured = (RadioButton)findViewById(R.id.featured_text);
        find = (RadioButton)findViewById(R.id.find_text);
        bottomBar = (RadioGroup)findViewById(R.id.bottom_bar);
        bottomBar.setOnCheckedChangeListener(this);
        initFragment();
    }

    private void initFragment(){
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mComicListFragment = new ComicListFragment();
        mFragments.add(mComicListFragment);
        mFeaturedFragment = new FeaturedFragment();
        mFragments.add(mFeaturedFragment);
        addAllFragment(mTransaction);
        showFragment(mTransaction , mComicListFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        changeFragment(i);
    }
    private void changeFragment(int id){
        if(mFragmentManager == null)
            mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        switch (id){
            case R.id.bookcase_text:
                showFragment(mTransaction,mComicListFragment);
                break;
            case R.id.featured_text:
                showFragment(mTransaction,mFeaturedFragment);
                break;

           /* case R.id.library_text:
                mTransaction.hide(mComicListFragment);
                break;
            case R.id.find_text:
                break;*/
        }
    }
    private void addAllFragment(FragmentTransaction transaction){
        for (Fragment fragment : mFragments){
            transaction.add(R.id.content,fragment);
        }
    }

    private void showFragment(FragmentTransaction transaction,Fragment fragment){
        for(Fragment fragment1 : mFragments){
            transaction.hide(fragment1);
        }
        transaction.show(fragment);
        mCurrentFragment = fragment;
        transaction.commit();
    }

}
