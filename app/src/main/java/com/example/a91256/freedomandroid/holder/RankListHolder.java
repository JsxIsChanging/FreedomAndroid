package com.example.a91256.freedomandroid.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 91256 on 2017/4/14.
 */

public class RankListHolder extends RecyclerView.ViewHolder{

    public RelativeLayout item;
//    public SimpleDraweeView img;
    public ImageView img;
    public TextView title;
    public TextView type;
    public TextView des;
    public RankListHolder(View itemView) {
        super(itemView);
        item = (RelativeLayout)itemView.findViewById(R.id.item_layout);
        img = (ImageView)itemView.findViewById(R.id.detail_img);
        title = (TextView)itemView.findViewById(R.id.detail_title);
        type = (TextView)itemView.findViewById(R.id.detail_type);
        des = (TextView)itemView.findViewById(R.id.detail_des);
    }
}