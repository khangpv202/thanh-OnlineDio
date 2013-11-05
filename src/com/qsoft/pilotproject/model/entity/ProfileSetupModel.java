package com.qsoft.pilotproject.model.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import com.qsoft.pilotproject.utils.Common;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhTran
 * Date: 11/5/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProfileSetupModel implements BaseColumns
{
    private String id;
    private String facebook_id;
    private String username;
    private String password;
    private String avatar;
    private String cover_image;
    private String display_image;
    private String full_name;
    private String phone;
    private String birthday;
    private String gender;
    private String country_id;
    private String storage_plan_id;
    private String description;
    private String created_at;
    private String updated_at;
    private String sounds;
    private String favorites;
    private String likes;
    private String followings;
    private String audiences;

    public ProfileSetupModel(String id, String facebook_id, String username, String password, String avatar, String cover_image,
                             String display_image, String full_name, String phone, String birthday, String gender, String country_id,
                             String storage_plan_id, String description, String created_at, String updated_at, String sounds,
                             String favorites, String likes, String followings, String audiences) {
        this.id = id;
        this.facebook_id = facebook_id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.cover_image = cover_image;
        this.display_image = display_image;
        this.full_name = full_name;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.country_id = country_id;
        this.storage_plan_id = storage_plan_id;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.sounds = sounds;
        this.favorites = favorites;
        this.likes = likes;
        this.followings = followings;
        this.audiences = audiences;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getDisplay_image() {
        return display_image;
    }

    public void setDisplay_image(String display_image) {
        this.display_image = display_image;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getStorage_plan_id() {
        return storage_plan_id;
    }

    public void setStorage_plan_id(String storage_plan_id) {
        this.storage_plan_id = storage_plan_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSounds() {
        return sounds;
    }

    public void setSounds(String sounds) {
        this.sounds = sounds;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getFollowings() {
        return followings;
    }

    public void setFollowings(String followings) {
        this.followings = followings;
    }

    public String getAudiences() {
        return audiences;
    }

    public void setAudiences(String audiences) {
        this.audiences = audiences;
    }

    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Common.PROFILE_SETUP_ID,id);
        contentValues.put(Common.PROFILE_SETUP_FACEBOOK_ID,facebook_id);
        contentValues.put(Common.PROFILE_SETUP_USERNAME,username);
        contentValues.put(Common.PROFILE_SETUP_PASSWORD,password);
        contentValues.put(Common.PROFILE_SETUP_AVATAR,avatar);
        contentValues.put(Common.PROFILE_SETUP_COVER_IMAGE,cover_image);
        contentValues.put(Common.PROFILE_SETUP_DISPLAY_IMAGE,display_image);
        contentValues.put(Common.PROFILE_SETUP_FULL_NAME,full_name);
        contentValues.put(Common.PROFILE_SETUP_PHONE,phone);
        contentValues.put(Common.PROFILE_SETUP_BIRTHDAY,birthday);
        contentValues.put(Common.PROFILE_SETUP_GENDER,gender);
        contentValues.put(Common.PROFILE_SETUP_COUNTRY_ID,country_id);
        contentValues.put(Common.PROFILE_SETUP_STORAGE_PLAN_ID,storage_plan_id);
        contentValues.put(Common.PROFILE_SETUP_DESCRIPTION,description);
        contentValues.put(Common.PROFILE_SETUP_CREATE_AT,created_at);
        contentValues.put(Common.PROFILE_SETUP_UPDATE_AT,updated_at);
        contentValues.put(Common.PROFILE_SETUP_SOUND,sounds);
        contentValues.put(Common.PROFILE_SETUP_FAVORITES,favorites);
        contentValues.put(Common.PROFILE_SETUP_LIKES,likes);
        contentValues.put(Common.PROFILE_SETUP_FOLLOWINGS,followings);
        contentValues.put(Common.PROFILE_SETUP_AUDIENCES,audiences);
        return contentValues;
    }

    public static ProfileSetupModel fromCursor(Cursor curProfile){
        String id = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_ID));
        String facebook_id = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_FACEBOOK_ID));
        String username = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_USERNAME));
        String password = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_PASSWORD));
        String avatar = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_AVATAR));
        String cover_image = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_COVER_IMAGE));
        String display_image = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_DISPLAY_IMAGE));
        String full_name = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_FULL_NAME));
        String phone = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_PHONE));
        String birthday = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_BIRTHDAY));
        String gender = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_GENDER));
        String country_id = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_COUNTRY_ID));
        String storage_plan_id = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_STORAGE_PLAN_ID));
        String description = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_DESCRIPTION));
        String created_at = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_CREATE_AT));
        String updated_at = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_UPDATE_AT));
        String sounds = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_SOUND));
        String favorites = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_FAVORITES));
        String likes = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_LIKES));
        String followings = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_FOLLOWINGS));
        String audiences = curProfile.getString(curProfile.getColumnIndex(Common.PROFILE_SETUP_AUDIENCES));
        return new ProfileSetupModel(id,facebook_id,username,password,avatar,cover_image,display_image,full_name,phone,birthday,
                gender,country_id,storage_plan_id,description,created_at,updated_at,sounds,favorites,likes,followings,audiences);
    }
}
