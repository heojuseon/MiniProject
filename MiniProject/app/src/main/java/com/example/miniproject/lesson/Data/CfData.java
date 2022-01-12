package com.example.miniproject.lesson.Data;

public class CfData {

    int image;
    int image2;
    int image3;
    int image4;
    int type;

    String name;
    String brand_name;
    String brand_color;
    String brand_price;

    public CfData(int image, int image2, int image3, int image4, int type, String name, String brand_name, String brand_color, String brand_price) {
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.type = type;
        this.name = name;
        this.brand_name = brand_name;
        this.brand_color = brand_color;
        this.brand_price = brand_price;
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

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getBrand_color() {
        return brand_color;
    }

    public String getBrand_price() {
        return brand_price;
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

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setBrand_color(String brand_color) {
        this.brand_color = brand_color;
    }

    public void setBrand_price(String brand_price) {
        this.brand_price = brand_price;
    }
}
