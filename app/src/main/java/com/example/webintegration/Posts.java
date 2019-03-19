package com.example.webintegration;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Posts {
    @SerializedName("posts")
    private List<Users> list;

    public List<Users> getList() {
        return list;
    }
}
