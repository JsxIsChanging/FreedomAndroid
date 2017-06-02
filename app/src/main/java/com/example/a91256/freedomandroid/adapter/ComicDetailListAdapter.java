package com.example.a91256.freedomandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.bean.ChapterBean;
import com.example.a91256.freedomandroid.holder.ComicDetailLIstHolder;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/5/31.
 */

public class ComicDetailListAdapter extends RecyclerView.Adapter<ComicDetailLIstHolder> {

    private final int TYPE_NORMAL = -1;
    private final int TYPE_HEADER_OR_FOOTER_BASE = 10000;

    private ArrayList<View> headerViews = new ArrayList<>();
    private ArrayList<View> footerViews = new ArrayList<>();

    private ArrayList<ChapterBean> data;
    private Context context;

    public ComicDetailListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ComicDetailLIstHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (isHeader(i)) {
            return new ComicDetailLIstHolder(headerViews.get(i));
        }
        if (isFooter(i)) {
            return new ComicDetailLIstHolder(footerViews.get(i - TYPE_HEADER_OR_FOOTER_BASE));
        }
        return new ComicDetailLIstHolder(
                LayoutInflater.from(context).inflate(R.layout.comic_detail_chapterlist_item, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(ComicDetailLIstHolder comicDetailLIstHolder, int i) {
        if (i < headerViews.size() || i >= getItemCount() - footerViews.size()) {
            return;
        }
        if (data != null && !data.isEmpty()) {
            i -= headerViews.size();
            ChapterBean bean = data.get(i);
            renderIsNew(bean.getIs_new(), comicDetailLIstHolder.isNew);
            comicDetailLIstHolder.title.setText(bean.getName());
            renderIsLocked(bean.isHas_locked_image(), comicDetailLIstHolder.lock);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < headerViews.size()) {
            return (int) headerViews.get(position).getTag();
        }
        int footerPosition = position - (getItemCount() - footerViews.size());
        if (footerPosition >= 0) {
            return (int) footerViews.get(footerPosition).getTag();
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        int count = data != null ? data.size() : 0;
        return count + headerViews.size() + footerViews.size();
    }

    public void setData(ArrayList<ChapterBean> list) {
        this.data = list;
    }

    private void renderIsNew(int isNew, View view) {
        if (isNew != 0) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

    private void renderIsLocked(boolean isLocked, View view) {
        if (isLocked) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    public void addHeaderView(View view) {
        /*if(headerView == null){
            headerView = view;
            notifyDataSetChanged();
            return;
        }
        throw new RuntimeException("ComicDetailListAdapter -- forgot remove headerview");*/
        view.setTag(headerViews.size());
        headerViews.add(view);
    }

    public void addFooterView(View view) {
        /*if(footerView == null){
            footerView = view;
            notifyDataSetChanged();
            return;
        }
        throw new RuntimeException("ComicDetailListAdapter -- forgot remove footerView");*/
        view.setTag(TYPE_HEADER_OR_FOOTER_BASE + footerViews.size());
        footerViews.add(view);
    }

    private boolean isHeader(int type) {
        boolean isHeader = false;
        if (type < TYPE_HEADER_OR_FOOTER_BASE && type > TYPE_NORMAL) {
            isHeader = true;
        }
        return isHeader;
    }

    private boolean isFooter(int type) {
        boolean isFooter = false;
        if (type >= TYPE_HEADER_OR_FOOTER_BASE) {
            isFooter = true;
        }
        return isFooter;
    }


}
