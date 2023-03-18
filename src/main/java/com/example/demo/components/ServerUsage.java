package com.example.demo.components;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//using mongoDB
@Document
public class ServerUsage {
    @Id
    private String dateId;
    private String name;


    public ServerUsage() {
    }

    public ServerUsage(String name, String date) {
        this.name = name;
        this.dateId = date;
    }

    public String getId() {
        return dateId;
    }

    public void setId(String id) {
        this.dateId = dateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
