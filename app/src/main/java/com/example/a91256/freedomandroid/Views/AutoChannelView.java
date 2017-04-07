package com.example.a91256.freedomandroid.Views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.bean.RankinglistBean;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/3/31.
 */

public class AutoChannelView extends RelativeLayout{

    private ArrayList<RankinglistBean> items;
    private View mContainer;
    private HorizontalScrollView myScrollView;
    private LinearLayout layout;
    private Context context;
    private int currentPosition = 0;
    private OnChannelSelectedListener listener;
    private ArrayList<View> mViewList = new ArrayList<>();

    public void setChannel(ArrayList<RankinglistBean> list){
        this.items = list;
        setData();
    }

    public void init(OnChannelSelectedListener listener){
        mContainer = View.inflate(context,R.layout.channel_menu,null);
        myScrollView = (HorizontalScrollView) mContainer.findViewById(R.id.scroll);
        layout = (LinearLayout)mContainer.findViewById(R.id.layout);
        this.listener = listener;
    }


    public AutoChannelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    private void setData(){
        removeAllViews();
        TextView textView = null;
        RankinglistBean bean = null;
        mViewList.clear();
        layout.removeAllViews();
        for(int i = 0;i< items.size() ;i++){
            bean = items.get(i);
            View v = View.inflate(context,R.layout.channel_view_item,null);
            textView = (TextView)v.findViewById(R.id.channel_name);
            textView.setText(bean.getTitle());
            v.setTag(i);
            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (Integer) view.getTag();
                    changeChannel(position);
                    listener.onChannelSelected(position);
                }
            });
            layout.addView(v);
            mViewList.add(v);
        }
        if(mViewList.size() <= 0 || mViewList.size() <= currentPosition || mViewList.get(currentPosition) == null){
            return;
        }
        textView = (TextView) mViewList.get(currentPosition).findViewById(R.id.channel_name);
        textView.setTextColor(Color.rgb(255,0,0));
        addView(mContainer);
    }

    public void changeChannel(int position){
        View view = mViewList.get(currentPosition);
        TextView textView = (TextView)view.findViewById(R.id.channel_name);
        textView.setTextColor(Color.rgb(128,128,128));
        currentPosition = position;
        view = mViewList.get(currentPosition);
        textView = (TextView)view.findViewById(R.id.channel_name);
        textView.setTextColor(Color.rgb(255,0,0));
        int width = mViewList.get(0).getWidth();
        myScrollView.smoothScrollTo((position)*width,0);
    }

    public interface OnChannelSelectedListener{
        void onChannelSelected(int position);
    }

}
