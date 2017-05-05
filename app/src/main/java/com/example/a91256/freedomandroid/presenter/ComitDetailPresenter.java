package com.example.a91256.freedomandroid.presenter;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.base.BasePresenter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.model.ComicDetailJsonModel;

/**
 * Created by 91256 on 2017/5/3.
 */

public class ComitDetailPresenter extends BasePresenter<BaseModel,BaseView> {


    public ComitDetailPresenter(final BaseView view) {
        ComicDetailJsonModel model = new ComicDetailJsonModel(new BaseJsonCallBack() {
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

    public void loadData(String comicId){
        view.showLoading();
        ((ComicDetailJsonModel)model).getDetailData(comicId);
    }
}
