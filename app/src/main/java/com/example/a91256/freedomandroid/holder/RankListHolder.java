package com.example.a91256.freedomandroid.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 91256 on 2017/4/14.
 */

public class RankListHolder extends RecyclerView.ViewHolder{

    public SimpleDraweeView img;
    public TextView title;
    public TextView type;
    public TextView des;
    public RankListHolder(View itemView) {
        super(itemView);
        img = (SimpleDraweeView)itemView.findViewById(R.id.detail_img);
        type = (TextView)itemView.findViewById(R.id.detail_type);
        des = (TextView)itemView.findViewById(R.id.detail_des);
        title = (TextView)itemView.findViewById(R.id.detail_title);
    }
}