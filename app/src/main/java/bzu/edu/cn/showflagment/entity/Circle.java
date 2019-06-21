package bzu.edu.cn.showflagment.entity;

/**
 * Created by admin on 2019/6/19.
 */
public class Circle {

    private String icon;
    private String title;
    private String content;//说说内容
    private long comment;//新闻评论数

    public Circle(String icon, String title, String content, long comment) {
        this.title=title;
        this.icon = icon;
        this.content = content;
        this.comment = comment;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comment=" + comment +
                '}';
    }
}
