package com.appsterden.chatcity.model;

/**
 * Created by Nithin on 5/21/2016.
 */
public class AiResponseData {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}