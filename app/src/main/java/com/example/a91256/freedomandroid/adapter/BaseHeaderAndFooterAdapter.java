package com.example.a91256.freedomandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/5/31.
 */

public abstract class BaseHeaderAndFooterAdapter<T extends RecyclerView.ViewHolder,D> extends RecyclerView.Adapter<T> {

    protected final int TYPE_NORMAL = 0;
    private final int TYPE_HEADER_BASE = 10000;
    private final int TYPE_FOOTER_BASE = 20000;

    private ArrayList<View> headerViews = new ArrayList<>();
    private ArrayList<View> footerViews = new ArrayList<>();

    private ArrayList<D> data;
    protected Context context;

    public BaseHeaderAndFooterAdapter( Context context) {
        this.context = context;
    }

    public void setData(ArrayList<D> list) {
        this.data = list;
    }

    protected ArrayList<D> getData(){
        return data;
    }

    @Override
    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (isHeader(i)) {
            return creatHeaderOrFooterHolder(headerViews.get(i - TYPE_HEADER_BASE));
        }
        if (isFooter(i)) {
            return creatHeaderOrFooterHolder(footerViews.get(i - TYPE_FOOTER_BASE));
        }
        return creatViewHolder(viewGroup,i);
    }

    @Override
    public void onBindViewHolder(T viewHolder, int i) {
        if (i < headerViews.size() || i >= getItemCount() - footerViews.size()) {
            return;
        }
        if (data != null && !data.isEmpty()) {
            i -= headerViews.size();
            renderItemView(viewHolder, i);
        }
    }

    @Override
    public int getItemCount() {
        int count = data != null ? data.size() : 0;
        return count + headerViews.size() + footerViews.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < headerViews.size()) {
//            return (int) headerViews.get(position).getTag();
            return position + TYPE_HEADER_BASE;
        }
        int footerPosition = position - (getItemCount() - footerViews.size());
        if (footerPosition >= 0) {
//            return (int) footerViews.get(footerPosition).getTag();
            return footerPosition + TYPE_FOOTER_BASE;
        }
        return getItemType(position - headerViews.size());
    }

    public void addHeaderView(View view) {
//        view.setTag(headerViews.size());
        headerViews.add(0,view);
        notifyDataSetChanged();
    }

    public void addFooterView(View view) {
//        view.setTag(TYPE_HEADER_OR_FOOTER_BASE + footerViews.size());
        footerViews.add(view);
        notifyDataSetChanged();
    }

    public boolean removeHeader(View view){
        boolean b =  headerViews.remove(view);
        notifyDataSetChanged();
        return b;
    }

    public boolean removeFooter(View view){
        boolean b = footerViews.remove(view);
        notifyDataSetChanged();
        return b;
    }

    public void removeAllHeaders(){
        headerViews = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void removeAllFooters(){
        footerViews = new ArrayList<>();
        notifyDataSetChanged();
    }

    private boolean isHeader(int type) {
        boolean isHeader = false;
        if (type < TYPE_FOOTER_BASE && type >= TYPE_HEADER_BASE) {
            isHeader = true;
        }
        return isHeader;
    }

    private boolean isFooter(int type) {
        boolean isFooter = false;
        if (type >= TYPE_FOOTER_BASE) {
            isFooter = true;
        }
        return isFooter;
    }

    protected Context getContext(){
        return context;
    }

    abstract int getItemType(int position);

    abstract void renderItemView(T viewHolder, int i);

    abstract T creatViewHolder(ViewGroup viewGroup,int i);

    abstract T creatHeaderOrFooterHolder(View view);

}
