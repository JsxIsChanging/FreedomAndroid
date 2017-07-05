package com.example.a91256.freedomandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.base.BaseView;


/**
 * Created by 91256 on 2017/6/29.
 */

public class FeaturedFragment extends Fragment implements BaseView {
    private final String TAG = "FeaturedFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_featured,container,false);
        return convertView;
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
