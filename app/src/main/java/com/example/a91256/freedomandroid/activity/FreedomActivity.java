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

public class FreedomActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioButton bookcase;
    private RadioButton library;
    private RadioButton featured;
    private RadioButton find;
    private RadioGroup bottomBar;
    private FragmentManager mFragmentManager;
    private ComicListFragment mComicListFragment;
    private FragmentTransaction mTransaction;
    private Fragment mCurrentFragment;

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
        mCurrentFragment = mComicListFragment;
        mTransaction.add(R.id.content,mComicListFragment);
        mTransaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        changeFragment(i);
    }
    private void changeFragment(int id){
        if(mFragmentManager == null)
            mFragmentManager = getSupportFragmentManager();
        if(mTransaction == null)
            mTransaction = mFragmentManager.beginTransaction();
        switch (id){
            case R.id.bookcase_text:
                if(mComicListFragment == null){
                    mComicListFragment = new ComicListFragment();
                    mTransaction.add(R.id.content,mComicListFragment);
                }
                mTransaction.show(mComicListFragment);
                break;
            case R.id.library_text:
                mTransaction.hide(mComicListFragment);
                break;
            case R.id.featured_text:
                break;
            case R.id.find_text:
                break;
        }
        mTransaction.commit();
    }
}
