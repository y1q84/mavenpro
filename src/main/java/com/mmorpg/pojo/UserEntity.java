package com.mmorpg.pojo;

/**
 * author:ydx
 * create 2019\7\6 0006
 */
public class UserEntity {
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
