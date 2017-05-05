package com.example.a91256.freedomandroid.model;

import android.util.Log;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.utils.BaseRequestUtil;
import com.example.a91256.freedomandroid.utils.RetrofitApi;

import rx.Observer;

/**
 * Created by 91256 on 2017/5/3.
 */

public class ComicDetailJsonModel implements BaseModel {
    private BaseJsonCallBack callBack;
    public ComicDetailJsonModel(BaseJsonCallBack callBack) {
        this.callBack = callBack;
    }

    public void getDetailData(String comicId){
        RetrofitApi api = BaseRequestUtil.createApi(RetrofitApi.class);
        api.getComicListObservable().subscribe(new Observer<ComicListBean>() {
            @Override
            public void onCompleted() {
                callBack.success(null);
            }

            @Override
            public void onError(Throwable e) {
                callBack.fail();
            }

            @Override
            public void onNext(ComicListBean comicListBean) {
                callBack.success(comicListBean);
            }
        });
    }
}
