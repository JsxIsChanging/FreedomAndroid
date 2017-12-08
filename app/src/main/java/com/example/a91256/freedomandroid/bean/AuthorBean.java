package com.example.a91256.freedomandroid.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 91256 on 2017/4/10.
 */

public class AuthorBean implements Parcelable {

    /**
     * avatar : http://k.avatar.u17i.com/2010/0816/2786_882d854b637b5a15158a443afe73cebb_1281889937.big.jpg
     * name : 许辰
     * id : 2786
     */

    private String avatar;
    private String name;
    private String id;

    protected AuthorBean(Parcel in) {
        avatar = in.readString();
        name = in.readString();
        id = in.readString();
    }

    public static final Creator<AuthorBean> CREATOR = new Creator<AuthorBean>() {
        @Override
        public AuthorBean createFromParcel(Parcel in) {
            return new AuthorBean(in);
        }

        @Override
        public AuthorBean[] newArray(int size) {
            return new AuthorBean[size];
        }
    };

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatar);
        dest.writeString(name);
        dest.writeString(id);
    }

}
