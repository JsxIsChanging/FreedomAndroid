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

public class ComicDetailListAdapter extends BaseHeaderAndFooterAdapter<ComicDetailLIstHolder, ChapterBean> {


    public ComicDetailListAdapter(Context context) {
        super(context);
    }

    @Override
    void renderItemView(ComicDetailLIstHolder viewHolder, int i) {
        ChapterBean bean = getData().get(i);
        renderIsNew(bean.getIs_new(), viewHolder.isNew);
        viewHolder.title.setText(bean.getName());
        renderIsLocked(bean.isHas_locked_image(), viewHolder.lock);
    }


    @Override
    protected ComicDetailLIstHolder creatViewHolder(ViewGroup viewGroup, int i) {
        return new ComicDetailLIstHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.comic_detail_chapterlist_item, viewGroup, false)
        );
    }

    @Override
    ComicDetailLIstHolder creatHeaderOrFooterHolder(View view) {
        return new ComicDetailLIstHolder(view);
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

}
