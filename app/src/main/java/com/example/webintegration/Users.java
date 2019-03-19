package com.example.webintegration;

public class Users {

    private String name;
    private String message;
    private String profileImage;

    public Users(String name, String message, String profileImage) {
        this.name = name;
        this.message = message;
        this.profileImage = profileImage;
    }

    public Users() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
