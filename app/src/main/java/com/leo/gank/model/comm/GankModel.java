package com.leo.gank.model.comm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public class GankModel extends RealmObject implements Parcelable{

    /**
     * _id : 56cc6d23421aa95caa707c52
     * createdAt : 2015-08-07T01:21:06.112Z
     * desc : 8.7——（1）
     * publishedAt : 2015-08-07T03:57:47.310Z
     * type : 福利
     * url : http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg
     * used : true
     * who : 张涵宇
     */

    @PrimaryKey
    private String _id;

    private Date createdAt;
    private String desc;
    private Date publishedAt;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "GankModel{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeLong(createdAt != null ? createdAt.getTime() : -1);
        dest.writeString(this.desc);
        dest.writeLong(publishedAt != null ? publishedAt.getTime() : -1);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeByte(used ? (byte) 1 : (byte) 0);
        dest.writeString(this.who);
    }

    public GankModel() {
    }

    protected GankModel(Parcel in) {
        this._id = in.readString();
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        this.desc = in.readString();
        long tmpPublishedAt = in.readLong();
        this.publishedAt = tmpPublishedAt == -1 ? null : new Date(tmpPublishedAt);
        this.type = in.readString();
        this.url = in.readString();
        this.used = in.readByte() != 0;
        this.who = in.readString();
    }

    public static final Creator<GankModel> CREATOR = new Creator<GankModel>() {
        @Override
        public GankModel createFromParcel(Parcel source) {
            return new GankModel(source);
        }

        @Override
        public GankModel[] newArray(int size) {
            return new GankModel[size];
        }
    };
}
