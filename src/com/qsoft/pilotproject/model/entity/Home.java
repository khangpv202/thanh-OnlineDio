package com.qsoft.pilotproject.model.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import com.qsoft.pilotproject.utils.Common;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhTran
 * Date: 11/3/13
 * Time: 8:29 AM
 * To change this template use File | Settings | File Templates.
 */

public class Home implements BaseColumns{
    private String id;

    private String user_id;

    private String title;

    private String thumbnail;

    private String sound_path;

    private String description;

    private String duration;

    private String played;

    private String created_at;

    private String updated_at;

    private String likes;

    private String viewed;

    private String comments;

    private String username;

    private String display_name;

    private String avatar;

    public Home(String id, String user_id, String title, String thumbnail, String sound_path, String description,
                String duration, String played, String created_at, String updated_at, String likes, String viewed,
                String comments, String username, String display_name, String avatar) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.sound_path = sound_path;
        this.description = description;
        this.duration = duration;
        this.played = played;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.likes = likes;
        this.viewed = viewed;
        this.comments = comments;
        this.username = username;
        this.display_name = display_name;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSound_path() {
        return sound_path;
    }

    public void setSound_path(String sound_path) {
        this.sound_path = sound_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViewed() {
        return viewed;
    }

    public void setViewed(String viewed) {
        this.viewed = viewed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ContentValues getContentValues()
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Common.FEED_ID,id);
        contentValues.put(Common.FEED_USER_ID,user_id);
        contentValues.put(Common.FEED_TITLE,title);
        contentValues.put(Common.FEED_THUMBNAIL,thumbnail);
        contentValues.put(Common.FEED_DESCRIPTION,description);
        contentValues.put(Common.FEED_SOUND_PATH,sound_path);
        contentValues.put(Common.FEED_DURATION,duration);
        contentValues.put(Common.FEED_PLAYED,played);
        contentValues.put(Common.FEED_CREATED_AT,created_at);
        contentValues.put(Common.FEED_UPDATED_AT,updated_at);
        contentValues.put(Common.FEED_LIKES,likes);
        contentValues.put(Common.FEED_VIEWED,viewed);
        contentValues.put(Common.FEED_COMMENTS,comments);
        contentValues.put(Common.FEED_USERNAME,username);
        contentValues.put(Common.FEED_DISPLAY_NAME,display_name);
        contentValues.put(Common.FEED_AVATAR,avatar);
        return contentValues;
    }

    //get data from record cursor
    public static Home fromCursor(Cursor curHomeShow)
    {
        String id = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_ID));
        String userId = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_USER_ID));
        String title = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_TITLE));
        String thumbnail = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_THUMBNAIL));
        String description = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_DESCRIPTION));
        String sound_path = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_SOUND_PATH));
        String duration = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_DURATION));
        String played = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_PLAYED));
        String created_at = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_CREATED_AT));
        String updated_at = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_UPDATED_AT));
        String likes = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_LIKES));
        String viewed = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_VIEWED));
        String comments = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_COMMENTS));
        String username = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_USERNAME));
        String display_name = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_DISPLAY_NAME));
        String avatar = curHomeShow.getString(curHomeShow.getColumnIndex(Common.FEED_AVATAR));

        return new Home(userId, id, title, thumbnail, description, sound_path, duration, played, likes, viewed, comments, created_at, updated_at, username, display_name, avatar);
    }
}
