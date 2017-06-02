package com.example.a91256.freedomandroid.model;


import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.utils.BaseRequestUtil;
import com.example.a91256.freedomandroid.utils.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        /*api.getComicDetailObservable(comicId).subscribe(new Observer<ComicListBean>() {
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
        });*/
        api.getComicDetailCall(comicId).enqueue(new Callback<ComicListBean>() {
            @Override
            public void onResponse(Call<ComicListBean> call, Response<ComicListBean> response) {
                ComicListBean bean = response.body();
                callBack.success(bean);
            }

            @Override
            public void onFailure(Call<ComicListBean> call, Throwable t) {
                callBack.fail();
            }
        });
    }
}
