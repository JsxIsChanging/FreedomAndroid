package com.example.a91256.freedomandroid.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.a91256.freedomandroid.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 91256 on 2017/6/26.
 */

public class ChapterHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView img;
    public ChapterHolder(View itemView) {
        super(itemView);
        img = (SimpleDraweeView)itemView.findViewById(R.id.comic_image);
    }
}
