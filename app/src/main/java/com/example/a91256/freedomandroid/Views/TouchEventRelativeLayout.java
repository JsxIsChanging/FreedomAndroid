package com.example.a91256.freedomandroid.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by 91256 on 2017/6/1.
 */

public class TouchEventRelativeLayout extends RelativeLayout {

    private final String TAG = "TouchEventRelativeLayout";

    public TouchEventRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private OnComicDetailTouchListener listener;

    public TouchEventRelativeLayout(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(listener != null){
            return listener.onInterceptTouchEvent(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(listener != null){
            return listener.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public void setOnComicDetailTouchListener(OnComicDetailTouchListener listener) {
        this.listener = listener;
    }

    public interface OnComicDetailTouchListener{
        boolean onInterceptTouchEvent(MotionEvent event);

        boolean onTouchEvent(MotionEvent event);
    }

}
