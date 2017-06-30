package com.example.a91256.freedomandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.activity.ComicChapterActivity;
import com.example.a91256.freedomandroid.bean.ChapterBean;
import com.example.a91256.freedomandroid.holder.ComicDetailLIstHolder;


/**
 * Created by 91256 on 2017/5/31.
 */

public class ComicDetailListAdapter extends BaseHeaderAndFooterAdapter<ComicDetailLIstHolder, ChapterBean> {


    public ComicDetailListAdapter(Context context) {
        super(context);
    }

    @Override
    int getItemType(int position) {
        return TYPE_NORMAL;
    }

    @Override
    void renderItemView(ComicDetailLIstHolder viewHolder, int i) {
        ChapterBean bean = getData().get(i);
        final String chapterId = bean.getChapter_id();
        final int type = bean.getType();
        if(type == 0) {
            viewHolder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ComicChapterActivity.class);
                    intent.putExtra("chapterId", chapterId);
                    context.startActivity(intent);
                }
            });
        }else if(type == 3){
            viewHolder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"当前章节为Vip，请先登录",Toast.LENGTH_SHORT).show();
                }
            });
        }
        renderIsNew(bean.getIs_new(), viewHolder.isNew);
        viewHolder.title.setText(bean.getName());
        renderIsLocked(bean.getType(), viewHolder.lock);
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

    private void renderIsLocked(int type ,View view) {
        if (type == 3) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}
