package com.example.a91256.freedomandroid.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;

/**
 * Created by 91256 on 2017/5/31.
 */

public class ComicDetailLIstHolder extends RecyclerView.ViewHolder {
    public ImageView isNew;
    public TextView title;
    public ImageView lock;

    public ComicDetailLIstHolder(View itemView) {
        super(itemView);
        isNew =  (ImageView)itemView.findViewById(R.id.is_new);
        title = (TextView)itemView.findViewById(R.id.comic_title);
        lock = (ImageView) itemView.findViewById(R.id.is_locked);
    }
}
