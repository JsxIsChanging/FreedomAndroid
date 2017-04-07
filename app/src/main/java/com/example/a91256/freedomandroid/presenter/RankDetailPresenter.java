package com.example.a91256.freedomandroid.presenter;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.base.BasePresenter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.model.RankDetaiJsonModel;

/**
 * Created by 91256 on 2017/4/6.
 */

public class RankDetailPresenter extends BasePresenter<BaseModel,BaseView> {
    public RankDetailPresenter(final BaseView view) {
        RankDetaiJsonModel model = new RankDetaiJsonModel(new BaseJsonCallBack() {
            @Override
            public void success(Object object) {
                view.loadComplete(object);
                view.stopLoading();
            }

            @Override
            public void fail() {
                view.loadFail();
                view.stopLoading();
            }
        });
        attach(model,view);
    }

    public void loadData(int page,String argName,String argValue){
        view.showLoading();
        ((RankDetaiJsonModel)model).getRankListData(page,argName,argValue);
    }
}
