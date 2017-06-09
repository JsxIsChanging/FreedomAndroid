package com.example.a91256.freedomandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 91256 on 2017/6/9.
 */

public class ComicDetailImgAdapter extends BaseHeaderAndFooterAdapter {

    public ComicDetailImgAdapter(Context context) {
        super(context);
    }

    @Override
    int getItemType(int position) {
        return 0;
    }

    @Override
    void renderItemView(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    RecyclerView.ViewHolder creatViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    RecyclerView.ViewHolder creatHeaderOrFooterHolder(View view) {
        return null;
    }
}
