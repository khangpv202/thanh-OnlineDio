package com.qsoft.pilotproject.utils;

import android.net.Uri;
import com.qsoft.pilotproject.accountmanager.ParseComServerAuthenticate;
import com.qsoft.pilotproject.accountmanager.ServerAuthenticate;
import com.qsoft.pilotproject.model.contentProvider.HomeContentProvider;

public class Common
{
    private final int REQ_SIGNUP = 1;
    public final static String ARG_ACCOUNT_TYPE = "com.qsoft.onlinedio";
    public final static String ARG_AUTH_TYPE = "AUTH_TYPE";
    public final static String ARG_ACCOUNT_NAME = "ACCOUNT_NAME";
    public final static String ARG_IS_ADDING_NEW_ACCOUNT = "IS_ADDING_ACCOUNT";
    public static final String KEY_ERROR_MESSAGE = "ERR_MSG";
    public final static String PARAM_USER_PASS = "USER_PASS";
    public static final ServerAuthenticate sServerAuthenticate = new ParseComServerAuthenticate();

    public static final String USERDATA_USER_OBJ_ID = "userObjectId";   //Parse.com object id
    public static final String AUTHTOKEN_TYPE_READ_ONLY = "Read only";
    public static final String AUTHTOKEN_TYPE_READ_ONLY_LABEL = "Read only access to an Udinic account";

    public static final String AUTHTOKEN_TYPE_FULL_ACCESS = "Full access";
    public static final String AUTHTOKEN_TYPE_FULL_ACCESS_LABEL = "Full access to an Udinic account";

    //Home Note

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.syncadapter.homes";
    public static final String CONTENT_TYPE_PROFILE = "vnd.android.cursor.dir/vnd.syncadapter.profilesetup";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.syncadapter.homeitem";
    public static final String CONTENT_ITEM_TYPE_PROFILE = "vnd.android.cursor.item/vnd.syncadapter.profilesetupitem";
    public static final Uri CONTENT_URI = Uri.parse("content://"+ HomeContentProvider.AUTHORITY);
    public static final String HOME_TABLE_NAME = "home";

    // name entity home table
    public static final String FEED_ID ="id";
    public static final String FEED_USER_ID = "user_id";
    public static final String FEED_TITLE = "title";
    public static final String FEED_THUMBNAIL = "thumbnail";
    public static final String FEED_DESCRIPTION = "description";
    public static final String FEED_SOUND_PATH = "sound_path";
    public static final String FEED_DURATION = "duration";
    public static final String FEED_PLAYED = "played";
    public static final String FEED_CREATED_AT = "created_at";
    public static final String FEED_UPDATED_AT = "update_at";
    public static final String FEED_LIKES = "likes";
    public static final String FEED_VIEWED = "viewed";
    public static final String FEED_COMMENTS = "comments";
    public static final String FEED_USERNAME = "username";
    public static final String FEED_DISPLAY_NAME = "display_name";
    public static final String FEED_AVATAR = "avatar";

    //entity profile setup table
    public static final String PROFILE_SETUP_ID = "id";
    public static final String PROFILE_SETUP_FACEBOOK_ID = "facebook_id";
    public static final String PROFILE_SETUP_USERNAME = "username";
    public static final String PROFILE_SETUP_PASSWORD = "password";
    public static final String PROFILE_SETUP_AVATAR = "avatar";
    public static final String PROFILE_SETUP_COVER_IMAGE = "cover_image";
    public static final String PROFILE_SETUP_DISPLAY_IMAGE = "display_name";
    public static final String PROFILE_SETUP_FULL_NAME = "full_name";
    public static final String PROFILE_SETUP_PHONE = "phone";
    public static final String PROFILE_SETUP_BIRTHDAY = "birthday";
    public static final String PROFILE_SETUP_GENDER = "gender";
    public static final String PROFILE_SETUP_COUNTRY_ID = "country_id";
    public static final String PROFILE_SETUP_STORAGE_PLAN_ID = "storage_plan_id";
    public static final String PROFILE_SETUP_DESCRIPTION = "description";
    public static final String PROFILE_SETUP_CREATE_AT = "created_at";
    public static final String PROFILE_SETUP_UPDATE_AT = "updated_at";
    public static final String PROFILE_SETUP_SOUND = "sounds";
    public static final String PROFILE_SETUP_FAVORITES = "favorites";
    public static final String PROFILE_SETUP_LIKES = "likes";
    public static final String PROFILE_SETUP_FOLLOWINGS = "followings";
    public static final String PROFILE_SETUP_AUDIENCES = "audiences";
}