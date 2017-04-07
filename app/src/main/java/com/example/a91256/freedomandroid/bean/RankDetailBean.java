package com.example.a91256.freedomandroid.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 91256 on 2017/4/6.
 */

public class RankDetailBean {

    /**
     * conTag : 2317
     * cover : http://cover2.u17i.com/2017/03/1218_1490711817_Mmj8ZLwbmZ8T.sbig.jpg
     * name : 星STAR
     * comicId : 1383
     * description : 星盟大冒险，帅哥萌妹爆乳小清新= - <br />
     普通高中生白雨航一天看到一个陌生的网站，回答了奇怪的问题，开始了一段奇妙的旅程，成为了一名星盟战士！！（快点看）
     * flag : 3
     * tags : ["少年","搞笑","生活","科幻"]
     * author : 千亮
     */

    private String conTag;
    private String cover;
    private String name;
    private int comicId;
    private String description;
    private int flag;
    private String author;
    private ArrayList<String> tags;

    public String getConTag() {
        return conTag;
    }

    public void setConTag(String conTag) {
        this.conTag = conTag;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
