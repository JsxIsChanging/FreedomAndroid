package com.example.a91256.freedomandroid.presenter;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.base.BasePresenter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.model.ComitListJsonModel;

/**
 * Created by 91256 on 2017/3/22.
 */

public class ComicListPresenter extends BasePresenter<BaseModel,BaseView> {

    public ComicListPresenter(final BaseView view) {
        ComitListJsonModel model = new ComitListJsonModel(new BaseJsonCallBack() {
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

    public void loadData(){
        view.showLoading();
        ((ComitListJsonModel)model).getComicListData();
    }
}
