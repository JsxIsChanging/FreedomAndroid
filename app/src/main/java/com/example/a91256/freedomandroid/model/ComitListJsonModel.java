package com.example.a91256.freedomandroid.model;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.utils.BaseRequestUtil;
import com.example.a91256.freedomandroid.utils.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    }
}
