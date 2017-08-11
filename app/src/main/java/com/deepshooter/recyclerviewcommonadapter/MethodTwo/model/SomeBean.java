package com.deepshooter.recyclerviewcommonadapter.MethodTwo.model;

/**
 * Created by Avinash on 05-08-2017.
 */

public class SomeBean {

    private int serialNo;
    private String imageUrl ;

    public SomeBean(int serialNo, String imageUrl) {
        this.serialNo = serialNo;
        this.imageUrl = imageUrl;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
