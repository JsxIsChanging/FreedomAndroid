package com.example.a91256.freedomandroid.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.base.BaseView;


/**
 * Created by 91256 on 2017/6/29.
 */

public class FeaturedFragment extends Fragment implements BaseView {
    private final String TAG = "FeaturedFragment";

    private FrameLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_featured,container,false);
        layout = (FrameLayout) convertView.findViewById(R.id.text);
        convertView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoveByobjectAnimator(layout,200,1,2 *1000);
            }
        });
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
    private void showMoveByobjectAnimator(View view,float translationy,float alpha,long duration){
        if(alpha <= 0.1)alpha = 0;
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view,"translationY",translationy),
                ObjectAnimator.ofFloat(view,"alpha",alpha));
        set.setDuration(duration).start();
    }

}
