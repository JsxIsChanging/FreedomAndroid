package com.example.a91256.freedomandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.bean.ComicImage;
import com.example.a91256.freedomandroid.holder.ChapterHolder;

/**
 * Created by 91256 on 2017/6/26.
 */

public class ChapterAdapter extends BaseHeaderAndFooterAdapter<ChapterHolder,ComicImage> {

    OnChapterImageClickListener listener;

    public ChapterAdapter(Context context) {
        super(context);
    }

    @Override
    int getItemType(int position) {
        return TYPE_NORMAL;
    }

    @Override
    void renderItemView(ChapterHolder viewHolder, int i) {
        ComicImage item = getData().get(i);
        viewHolder.img.setImageURI(item.getLocation());
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick();
                }
            }
        });
    }

    @Override
    ChapterHolder creatViewHolder(ViewGroup viewGroup, int i) {
        return new ChapterHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.comit_chapter_img, viewGroup, false));
    }

    @Override
    ChapterHolder creatHeaderOrFooterHolder(View view) {
        return new ChapterHolder(view);
    }

    interface OnChapterImageClickListener{
        void onClick();
    }

    public void setOnChapterImageClickListener(OnChapterImageClickListener listener){
        this.listener = listener;
    }
}
