package com.example.miniproject.dbadapter.DbData;

import java.io.Serializable;


//Intent로 객체를 전달할때는 implements Serializable 사용해야한다.
public class DbInsData implements Serializable {
    String userimg;
    String name;
    String mainimg;
    String like;
    String tag;


    private static final long serialVersionUID = 1L;

    public DbInsData(String userimg, String name, String mainimg, String like, String tag) {
        this.userimg = userimg;
        this.name = name;
        this.mainimg = mainimg;
        this.like = like;
        this.tag = tag;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainimg() {
        return mainimg;
    }

    public void setMainimg(String mainimg) {
        this.mainimg = mainimg;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
