package com.example.a91256.freedomandroid.bean;

import java.io.Serializable;

/**
 * Created by 91256 on 2017/3/15.
 */

public class RankinglistBean implements Serializable{
    /**
     * title : 月票
     * subTitle : 来不及了快上车，老司机票选人气漫画，带你飞！
     * cover : http://image.mylife.u17t.com/2016/12/28/1482920243_f2kF1UculvH7.jpg
     * argName : sort
     * argValue : 23
     * rankingType : 月票值
     */

    private String title;
    private String subTitle;
    private String cover;
    private String argName;
    private String argValue;
    private String rankingType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public String getArgValue() {
        return argValue;
    }

    public void setArgValue(String argValue) {
        this.argValue = argValue;
    }

    public String getRankingType() {
        return rankingType;
    }

    public void setRankingType(String rankingType) {
        this.rankingType = rankingType;
    }
}