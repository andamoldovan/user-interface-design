package com.example.anda.colocviu.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReceivedUser implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("display")
    private String name;

    @SerializedName("token")
    private String token;

    public ReceivedUser() {
    }

    public ReceivedUser(String id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ReceivedUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
