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
import rx.Observable;
import rx.Observer;

/**
 * Created by 91256 on 2017/3/21.
 */

public class ComitListJsonModel implements BaseModel {

    private BaseJsonCallBack callBack;
    public ComitListJsonModel(BaseJsonCallBack callBack) {
        this.callBack = callBack;
    }

    public void getComicListData(){
        RetrofitApi api = BaseRequestUtil.createApi(RetrofitApi.class);
        Call<ComicListBean> call = api.getComicListCall();
        call.enqueue(new Callback<ComicListBean>() {
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
        /*api.getComicListObservable().subscribe(new Observer<ComicListBean>() {
            @Override
            public void onCompleted() {
                Log.e("jsx","onCompleted");
                callBack.success(null);
            }

            @Override
            public void onError(Throwable e) {
                callBack.fail();
                Log.e("jsx","OnError");
            }

            @Override
            public void onNext(ComicListBean comicListBean) {
                Log.e("jsx","OnNext");
                callBack.success(comicListBean);
            }
        });*/
    }
}
