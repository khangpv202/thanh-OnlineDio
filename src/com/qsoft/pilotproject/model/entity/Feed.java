package com.qsoft.pilotproject.model.entity;

/**
 * User: binhtv
 * Date: 10/15/13
 * Time: 9:05 AM
 */
public class Feed
{
    private String title;
    private String display_name;
    private int likeNumber;
    private int commentNumber;
    private String updateStatus;
    private String avatar;

    public Feed() {

    }

    public Feed(String title, String display_name, int likeNumber, int commentNumber, String updateStatus, String avatar) {
        this.title = title;
        this.display_name = display_name;
        this.likeNumber = likeNumber;
        this.commentNumber = commentNumber;
        this.updateStatus = updateStatus;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDisplay_name()
    {
        return display_name;
    }

    public void setDisplay_name(String display_name)
    {
        this.display_name = display_name;
    }

    public int getLikeNumber()
    {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber)
    {
        this.likeNumber = likeNumber;
    }

    public int getCommentNumber()
    {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber)
    {
        this.commentNumber = commentNumber;
    }

    public String getUpdateStatus()
    {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus)
    {
        this.updateStatus = updateStatus;
    }
}
