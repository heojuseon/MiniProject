package com.example.miniproject.lesson.Data;

public class InsData {

    int image;
    int image2;
    int image3;
    int image4;
    int image5;
    int type;
    String name;
    String like;
    String tag;


    public InsData(int image, int image2, int image3, int image4, int image5, int type, String name, String like, String tag) {
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.type = type;
        this.name = name;
        this.like = like;
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public int getImage4() {
        return image4;
    }

    public int getImage5() {
        return image5;
    }

    public String getName() {
        return name;
    }

    public String getLike() {
        return like;
    }

    public String getTag() {
        return tag;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }

    public void setImage5(int image5) {
        this.image5 = image5;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
