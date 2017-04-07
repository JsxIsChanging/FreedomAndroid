package com.example.a91256.freedomandroid.base;

/**
 * Created by 91256 on 2017/3/13.
 */

public class BasePresenter <M ,V >{
    public M model;
    public V view;

    public void attach(M model,V view){
        this.model = model;
        this.view = view;
    }

    public void detach(){
        this.model = null;
        this.view = null;
    }

}
