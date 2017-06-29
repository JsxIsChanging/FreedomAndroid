package com.example.a91256.freedomandroid.model;

import android.util.Log;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.utils.BaseRequestUtil;
import com.example.a91256.freedomandroid.utils.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 91256 on 2017/6/9.
 */

public class ComicChapterJsonModel implements BaseModel {

    private BaseJsonCallBack callBack;

    public ComicChapterJsonModel(BaseJsonCallBack callBack) {
        this.callBack = callBack;
    }
    public void getChapterData(String chapterId) {
        RetrofitApi api = BaseRequestUtil.createApiNew(RetrofitApi.class);
        api.getComicChapterObservable(chapterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComicListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ComicDetailJsonModel", e.toString());
                        callBack.fail();
                    }

                    @Override
                    public void onNext(ComicListBean comicListBean) {
                        callBack.success(comicListBean);
                    }
                });
       /* api.getComicChapterCall(chapterId).enqueue(new Callback<ComicListBean>() {
            @Override
            public void onResponse(Call<ComicListBean> call, Response<ComicListBean> response) {
                ComicListBean bean = response.body();
                callBack.success(bean);
            }

            @Override
            public void onFailure(Call<ComicListBean> call, Throwable t) {
                callBack.fail();
            }
        });*/
    }
}
