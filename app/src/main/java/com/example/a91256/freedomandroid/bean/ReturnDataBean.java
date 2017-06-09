package com.example.a91256.freedomandroid.bean;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/3/15.
 */

public class ReturnDataBean {
    private ArrayList<RankinglistBean> rankinglist;
    private ArrayList<RankDetailBean> comics;
    private ArrayList<ChapterBean> chapter_list;
    private ArrayList<OtherWorkBean> otherWorks;
    private boolean hasMore;
    private int page;
    private ComicDetailBean comic;
    private String chapter_id;
    private String type;
    private String zip_file_high;
    private ArrayList<ComicImage> image_list;

    public ArrayList<RankinglistBean> getRankinglist() {
        return rankinglist;
    }

    public void setRankinglist(ArrayList<RankinglistBean> rankinglist) {
        this.rankinglist = rankinglist;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<RankDetailBean> getComics() {
        return comics;
    }

    public void setComics(ArrayList<RankDetailBean> comics) {
        this.comics = comics;
    }

    public ComicDetailBean getComic() {
        return comic;
    }

    public void setComic(ComicDetailBean comic) {
        this.comic = comic;
    }

    public ArrayList<ChapterBean> getChapter_list() {
        return chapter_list;
    }

    public void setChapter_list(ArrayList<ChapterBean> chapter_list) {
        this.chapter_list = chapter_list;
    }

    public ArrayList<OtherWorkBean> getOtherWorks() {
        return otherWorks;
    }

    public void setOtherWorks(ArrayList<OtherWorkBean> otherWorks) {
        this.otherWorks = otherWorks;
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getZip_file_high() {
        return zip_file_high;
    }

    public void setZip_file_high(String zip_file_high) {
        this.zip_file_high = zip_file_high;
    }

    public ArrayList<ComicImage> getImage_list() {
        return image_list;
    }

    public void setImage_list(ArrayList<ComicImage> image_list) {
        this.image_list = image_list;
    }
}
