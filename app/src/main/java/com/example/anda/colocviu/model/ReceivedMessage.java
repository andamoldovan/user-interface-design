package com.example.anda.colocviu.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReceivedMessage implements Serializable {

    @SerializedName("sender")
    private String sender;

    @SerializedName("text")
    private String text;

    @SerializedName("timestamp")
    private String timestamp;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
