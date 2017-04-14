package com.example.a91256.freedomandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.bean.RankDetailBean;
import com.example.a91256.freedomandroid.holder.RankListHolder;

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
    public void onBindViewHolder(RankListHolder myViewHolder, int i) {
        myViewHolder.img.setImageURI(items.get(i).getCover());
        myViewHolder.title.setText(items.get(i).getName());
        ArrayList<String> tags = items.get(i).getTags();
        String str = "";
        for(int m = 0; m< tags.size()-1; m++){
            str  = str + tags.get(m) + " | ";
        }
        str +=  tags.get(tags.size()-1);
        myViewHolder.type.setText(str);
        myViewHolder.des.setText("  " + items.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
