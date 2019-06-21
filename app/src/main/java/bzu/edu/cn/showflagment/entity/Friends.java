package bzu.edu.cn.showflagment.entity;

import java.io.Serializable;

/**
 * Created by admin on 2019/6/18.
 */
public class Friends implements Serializable{
    private long id;
    private String friendName;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Friends(String friendName) {
        this.friendName = friendName;
    }

    public Friends(String friendName, String text) {
        this.friendName = friendName;
        this.text = text;

    }

    public Friends(long id, String friendName) {
        this.id = id;
        this.friendName = friendName;
    }

    public Friends() {
    }
}
