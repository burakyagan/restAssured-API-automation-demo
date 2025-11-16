package com.trendyol.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

    private String id;
    private String email;
    private String fist_name;
    private String last_name;

    public UserData() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
