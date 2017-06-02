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

public class RankListAdapter extends RecyclerView.Adapter<RankListHolder>{
    private ArrayList<RankDetailBean> items = new ArrayList<>();
    private Context context;

    public RankListAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<RankDetailBean> list){
        this.items = list;
    }

    @Override
    public RankListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RankListHolder(LayoutInflater.from(context).inflate(R.layout.rank_detail_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(final RankListHolder myViewHolder, final int i) {
//        myViewHolder.img.setImageURI(items.get(i).getCover());
        Picasso.with(context).load(items.get(i).getCover()).into(myViewHolder.img);
        myViewHolder.title.setText(items.get(i).getName());
        ArrayList<String> tags = items.get(i).getTags();
        String str = "";
        for(int m = 0; m< tags.size()-1; m++){
            str  = str + tags.get(m) + " | ";
        }
        str +=  tags.get(tags.size()-1);
        myViewHolder.type.setText(str);
        myViewHolder.des.setText(items.get(i).getDescription());
        myViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String comicId =  String.valueOf(items.get(i).getComicId());
                Intent intent = new Intent();
                intent.putExtra("comicId",comicId);
                intent.setClass(context, ComicDetailActivity.class);
                context.startActivity(intent);*/

                ComicDetailActivity.launch((Activity) context,myViewHolder.img,String.valueOf(items.get(i).getComicId()),items.get(i).getCover());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
