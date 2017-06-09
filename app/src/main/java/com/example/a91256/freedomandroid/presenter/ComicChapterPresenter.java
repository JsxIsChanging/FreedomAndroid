package com.example.a91256.freedomandroid.presenter;

import com.example.a91256.freedomandroid.base.BaseModel;
import com.example.a91256.freedomandroid.base.BasePresenter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.callback.BaseJsonCallBack;
import com.example.a91256.freedomandroid.model.ComicChapterJsonModel;

/**
 * Created by 91256 on 2017/6/9.
 */

public class ComicChapterPresenter extends BasePresenter<BaseModel,BaseView> {
    public ComicChapterPresenter() {
        ComicChapterJsonModel model = new ComicChapterJsonModel(new BaseJsonCallBack() {
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

    public void loadData(String chapterId){
        view.showLoading();
        ((ComicChapterJsonModel)model).getChapterData(chapterId);
    }
}
