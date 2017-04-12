package com.example.a91256.freedomandroid.bean;

import java.util.List;

/**
 * Created by 91256 on 2017/4/10.
 */

public class ComicDetailBean {

    /**
     * name : 镇魂街
     * comic_id : 3166
     * short_description : 镇守恶灵之街的青年
     * accredit : 2
     * cover : http://cover2.u17i.com/2010/11/2786_1290484999_44z22704KDLT.sbig.jpg
     * is_vip : 3
     * type : 0
     * ori : http://cover2.u17i.com/temp/2010/11/2786_1290484999_44z22704KDLT.jpg
     * theme_ids : ["少年","魔幻"]
     * series_status : 0
     * last_update_time : 1491096710
     * description : 镇魂街，此乃吸纳亡灵镇压恶灵之地。这是一个人灵共存的世界，但不是每个人都能进入镇魂街，只有拥有守护灵的寄灵人才可进入。夏铃原本是一名普通的大学实习生，但一次偶然导致她的人生从此不再平凡。。。在这个充满恶灵的世界，你能与你的守护灵携手生存下去吗？官博@镇魂街：http://weibo.com/u/5195985855
     镇魂街微信号：zhenhunjieu17
     * cate_id : 故事漫画
     * week_more : 0
     * thread_id : 18787
     * last_update_week : 0
     * author : {"avatar":"http://k.avatar.u17i.com/2010/0816/2786_882d854b637b5a15158a443afe73cebb_1281889937.big.jpg","name":"许辰","id":"2786"}
     */

    private String name;
    private String comic_id;
    private String short_description;
    private int accredit;
    private String cover;
    private int is_vip;
    private String type;
    private String ori;
    private int series_status;
    private int last_update_time;
    private String description;
    private String cate_id;
    private String week_more;
    private String thread_id;
    private String last_update_week;
    private AuthorBean author;
    private List<String> theme_ids;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComic_id() {
        return comic_id;
    }

    public void setComic_id(String comic_id) {
        this.comic_id = comic_id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public int getAccredit() {
        return accredit;
    }

    public void setAccredit(int accredit) {
        this.accredit = accredit;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(int is_vip) {
        this.is_vip = is_vip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOri() {
        return ori;
    }

    public void setOri(String ori) {
        this.ori = ori;
    }

    public int getSeries_status() {
        return series_status;
    }

    public void setSeries_status(int series_status) {
        this.series_status = series_status;
    }

    public int getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(int last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getWeek_more() {
        return week_more;
    }

    public void setWeek_more(String week_more) {
        this.week_more = week_more;
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getLast_update_week() {
        return last_update_week;
    }

    public void setLast_update_week(String last_update_week) {
        this.last_update_week = last_update_week;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public List<String> getTheme_ids() {
        return theme_ids;
    }

    public void setTheme_ids(List<String> theme_ids) {
        this.theme_ids = theme_ids;
    }
}
