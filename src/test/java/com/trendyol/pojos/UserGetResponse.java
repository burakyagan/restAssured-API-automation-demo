package com.trendyol.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGetResponse {

    private int page;
    private int total;
    private List <UserData> data;

    public UserGetResponse( ) {}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }
}
