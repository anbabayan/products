package com.example.demo.components;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//using mongoDB
@Document
public class Session {
    @Id
    private String userId;
    private String lastLogin;
    private List<String> favorites;

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public Session(String lastLogin, List<String> favorites) {
        this.lastLogin = lastLogin;
        this.favorites = favorites;
    }

    public Session() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}
