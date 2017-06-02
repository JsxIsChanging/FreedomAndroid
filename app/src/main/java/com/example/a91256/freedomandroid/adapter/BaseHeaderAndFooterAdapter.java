package com.example.a91256.freedomandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 91256 on 2017/5/31.
 */

public abstract class BaseHeaderAndFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected View headerView;
    protected View footerView;

    protected final int TYPE_NORMAL = 0;
    protected final int TYPE_HEADER = 1;
    protected final int TYPE_FOOTER = 2;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return creatViewHolder(viewGroup,i);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        renderItemView(viewHolder,i);
    }

    @Override
    public int getItemCount() {
        return getTotalCount();
    }

    protected abstract int getTotalCount();

    protected abstract void renderItemView(RecyclerView.ViewHolder viewHolder, int i);

    protected abstract RecyclerView.ViewHolder creatViewHolder(ViewGroup viewGroup, int i);

}
