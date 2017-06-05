package com.example.a91256.freedomandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.activity.ComicDetailActivity;
import com.example.a91256.freedomandroid.bean.RankDetailBean;
import com.example.a91256.freedomandroid.holder.RankListHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/4/14.
 */

public class RankListAdapter extends BaseHeaderAndFooterAdapter<RankListHolder,RankDetailBean>{

    public RankListAdapter(Context context) {
        super(context);
    }

    @Override
    void renderItemView(final RankListHolder viewHolder, final int i) {
        final RankDetailBean bean = getData().get(i);
        Picasso.with(getContext()).load(bean.getCover()).into(viewHolder.img);
        viewHolder.title.setText(bean.getName());
        ArrayList<String> tags = bean.getTags();
        String str = "";
        for(int m = 0; m< tags.size()-1; m++){
            str  = str + tags.get(m) + " | ";
        }
        str +=  tags.get(tags.size()-1);
        viewHolder.type.setText(str);
        viewHolder.des.setText(bean.getDescription());
        viewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComicDetailActivity.launch((Activity) getContext(),viewHolder.img,String.valueOf(bean.getComicId()),bean.getCover());
            }
        });
    }

    @Override
    RankListHolder creatViewHolder(ViewGroup viewGroup, int i) {
        return new RankListHolder(LayoutInflater.from(getContext()).inflate(R.layout.rank_detail_item,viewGroup,false));
    }

    @Override
    RankListHolder creatHeaderOrFooterHolder(View view) {
        return new RankListHolder(view);
    }
}
