package bzu.edu.cn.showflagment.entity;

import java.io.Serializable;

/**
 * Created by admin on 2019/6/17.
 */
public class User implements Serializable{
    private long id;
    private String username;
    private String userpass;
    private int usericon;

    public User() {
    }

    public User(String username, String userpass) {
        this.username = username;
        this.userpass = userpass;
    }

    public User(long id, String username, String userpass, int usericon) {
        this.id = id;
        this.username = username;
        this.userpass = userpass;
        this.usericon = usericon;
    }

    public User(String username, String userpass, int usericon) {
        this.username = username;
        this.userpass = userpass;
        this.usericon = usericon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public int getUsericon() {
        return usericon;
    }

    public void setUsericon(int usericon) {
        this.usericon = usericon;
    }
}
