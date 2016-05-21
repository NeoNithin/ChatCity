package com.appsterden.chatcity.model;

/**
 * Created by Nithin on 5/21/2016.
 */
public class Data {
    private String message;
    private String place;
    private Boolean isSuccess;
    private Boolean isReq;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Boolean getReq() {
        return isReq;
    }

    public void setReq(Boolean req) {
        isReq = req;
    }


    @Override
    public String toString() {
        return "ClassPojo [message = " + message + ", isSuccess = " + isSuccess + "]";
    }
}
