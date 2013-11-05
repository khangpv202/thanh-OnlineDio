package com.qsoft.pilotproject.model.contentProvider;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import com.qsoft.pilotproject.model.entity.Home;
import com.qsoft.pilotproject.model.entity.ProfileSetupModel;
import com.qsoft.pilotproject.utils.Common;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhTran
 * Date: 11/3/13
 * Time: 8:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class HomeContentProvider extends ContentProvider {
    private static final String TAG = "HomeContentProvider";
    private static final String DATABASE_NAME = "onlineDio.db";
    private static final int DATABASE_VERSION = 1;
    public static final String HOME_TABLE_NAME = "home";
    public static final String PROFILE_SETUP_TABLE_NAME = "profilesetup";

    public static final String AUTHORITY = "com.qsoft.pilotproject.entity.contentProvider";
    private static final String DATABASE_CREATE = "CREATE TABLE " + HOME_TABLE_NAME + " ( " +
            BaseColumns._ID + " integer primary key autoincrement, "+
            Common.FEED_ID + " text, " +
            Common.FEED_USER_ID + " text, " +
            Common.FEED_TITLE + " text, " +
            Common.FEED_THUMBNAIL + " text, " +
            Common.FEED_DESCRIPTION + " text, " +
            Common.FEED_SOUND_PATH + " text, " +
            Common.FEED_DURATION + " text, " +
            Common.FEED_PLAYED + " text, " +
            Common.FEED_CREATED_AT + " text, " +
            Common.FEED_UPDATED_AT + " text, " +
            Common.FEED_LIKES + " text, " +
            Common.FEED_VIEWED + " text, " +
            Common.FEED_COMMENTS + " text, " +
            Common.FEED_USERNAME + " text, " +
            Common.FEED_DISPLAY_NAME + " text, " +
            Common.FEED_AVATAR + " text);";

    private static final String DATABASE_CREATE_PROFILE_SETUP = "CREATE TABLE "+ PROFILE_SETUP_TABLE_NAME+" ( "+
            BaseColumns._ID + " integer primary key autoincrement, "+
            Common.PROFILE_SETUP_ID + " text, "+
            Common.PROFILE_SETUP_FACEBOOK_ID + " text, "+
            Common.PROFILE_SETUP_USERNAME + " text, "+
            Common.PROFILE_SETUP_PASSWORD + " text, "+
            Common.PROFILE_SETUP_AVATAR + " text, "+
            Common.PROFILE_SETUP_COVER_IMAGE + " text, "+
            Common.PROFILE_SETUP_DISPLAY_IMAGE + " text, "+
            Common.PROFILE_SETUP_FULL_NAME + " text, "+
            Common.PROFILE_SETUP_PHONE + " text, "+
            Common.PROFILE_SETUP_BIRTHDAY + " text, "+
            Common.PROFILE_SETUP_GENDER + " text, "+
            Common.PROFILE_SETUP_COUNTRY_ID + " text, "+
            Common.PROFILE_SETUP_STORAGE_PLAN_ID + " text, "+
            Common.PROFILE_SETUP_DESCRIPTION + " text, "+
            Common.PROFILE_SETUP_CREATE_AT + " text, "+
            Common.PROFILE_SETUP_UPDATE_AT + " text, "+
            Common.PROFILE_SETUP_SOUND + " text, "+
            Common.PROFILE_SETUP_FAVORITES + " text, "+
            Common.PROFILE_SETUP_LIKES + " text, "+
            Common.PROFILE_SETUP_FOLLOWINGS + " text, "+
            Common.PROFILE_SETUP_AUDIENCES + " text);";

    String[] columns = {Common.FEED_TITLE, Common.FEED_DISPLAY_NAME, Common.FEED_LIKES, Common.FEED_COMMENTS, Common.FEED_UPDATED_AT, Common.FEED_AVATAR};
    public SQLiteDatabase mDB;

    private static final int HOMES = 1;
    private static final int HOME_ID = 2;
    private static final int PROFILE_SETUPS = 3;
    private static final int PROFILE_SETUP_ID = 4;

    private static HashMap<String, String> homeProjectionMap;

    private Context mContext;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, "home", HOMES);
        sUriMatcher.addURI(AUTHORITY, "home/*", HOME_ID);
        sUriMatcher.addURI(AUTHORITY,"profilesetup",PROFILE_SETUPS);
        sUriMatcher.addURI(AUTHORITY,"profilesetup/*",PROFILE_SETUP_ID);


        homeProjectionMap = new HashMap<String, String>();
        homeProjectionMap.put(Common.FEED_ID, Common.FEED_ID);
        homeProjectionMap.put(Common.FEED_USER_ID, Common.FEED_USER_ID);
        homeProjectionMap.put(Common.FEED_TITLE, Common.FEED_TITLE);
        homeProjectionMap.put(Common.FEED_THUMBNAIL, Common.FEED_THUMBNAIL);
        homeProjectionMap.put(Common.FEED_DESCRIPTION, Common.FEED_DESCRIPTION);
        homeProjectionMap.put(Common.FEED_SOUND_PATH, Common.FEED_SOUND_PATH);
        homeProjectionMap.put(Common.FEED_DURATION, Common.FEED_DURATION);
        homeProjectionMap.put(Common.FEED_PLAYED, Common.FEED_PLAYED);
        homeProjectionMap.put(Common.FEED_CREATED_AT, Common.FEED_CREATED_AT);
        homeProjectionMap.put(Common.FEED_UPDATED_AT, Common.FEED_UPDATED_AT);
        homeProjectionMap.put(Common.FEED_LIKES, Common.FEED_LIKES);
        homeProjectionMap.put(Common.FEED_VIEWED, Common.FEED_VIEWED);
        homeProjectionMap.put(Common.FEED_COMMENTS, Common.FEED_COMMENTS);
        homeProjectionMap.put(Common.FEED_USERNAME, Common.FEED_USERNAME);
        homeProjectionMap.put(Common.FEED_DISPLAY_NAME, Common.FEED_DISPLAY_NAME);
        homeProjectionMap.put(Common.FEED_AVATAR, Common.FEED_AVATAR);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public DatabaseHelper(Context mContext, String databaseName, SQLiteDatabase.CursorFactory factory, int version) {
            super(mContext, databaseName, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE_PROFILE_SETUP);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST home");
            db.execSQL("DROP TABLE IF EXIST profilesetup");
            onCreate(db);
        }
    }

    private DatabaseHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case HOMES:
                return Common.CONTENT_TYPE;
            case HOME_ID:
                return Common.CONTENT_ITEM_TYPE;
            case PROFILE_SETUPS:
                return Common.CONTENT_TYPE_PROFILE;
            case PROFILE_SETUP_ID:
                return Common.CONTENT_ITEM_TYPE_PROFILE;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);

        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int match = sUriMatcher.match(uri);
        switch (match)
        {
            case HOMES:
                SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
                builder.setTables(HOME_TABLE_NAME);
                return builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
            case HOME_ID:
                int id = (int) ContentUris.parseId(uri);
                SQLiteQueryBuilder builder1 = new SQLiteQueryBuilder();
                builder1.setTables(HOME_TABLE_NAME);
                builder1.appendWhere(Home._ID + "=" + id);
                return builder1.query(db, projection, selection, selectionArgs, null, null, sortOrder);
            case PROFILE_SETUPS:
                SQLiteQueryBuilder builder2 = new SQLiteQueryBuilder();
                builder2.setTables(PROFILE_SETUP_TABLE_NAME);
                return builder2.query(db,projection,selection,selectionArgs,null,null,sortOrder);
            case PROFILE_SETUP_ID:
                int idProfile = (int)ContentUris.parseId(uri);
                SQLiteQueryBuilder builder3 = new SQLiteQueryBuilder();
                builder3.setTables(PROFILE_SETUP_TABLE_NAME);
                builder3.appendWhere(ProfileSetupModel._ID + "=" + idProfile);
                return builder3.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        ContentValues values;
        if (initialValues != null){
            values = new ContentValues(initialValues);
        }else{
            values = new ContentValues();
        }

        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        assert db != null;
        Uri result;
        switch (sUriMatcher.match(uri)) {
            case HOMES:
                long id = db.insertOrThrow(HOME_TABLE_NAME, null, values);
                final Uri CONTENT_URI =
                        Common.CONTENT_URI.buildUpon().appendPath("home").build();
                result = Uri.parse(CONTENT_URI + "/" + id);
                break;
            case PROFILE_SETUPS:
                long idProfile = db.insert(PROFILE_SETUP_TABLE_NAME,null,values);
                final Uri CONTENT_URI_PROFILE =
                        Common.CONTENT_URI.buildUpon().appendPath("profilesetup").build();
                result = Uri.parse(CONTENT_URI_PROFILE+"/"+ idProfile);
                break;
            case PROFILE_SETUP_ID:
                throw new UnsupportedOperationException(
                        "Insert not supported on URI: " + uri);
            case HOME_ID:
                throw new UnsupportedOperationException(
                        "Insert not supported on URI: " + uri);
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(result, null);
        return result;
    }

    @Override
    public int delete(Uri uri, String where, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case HOMES:
                break;
            case PROFILE_SETUPS:
                break;
            case HOME_ID:
                where = where + "id = " + uri.getLastPathSegment();
                break;
            case PROFILE_SETUP_ID:
                where = where + "id = " + uri.getLastPathSegment();
                break;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);
        }
        int count = db.delete(HOME_TABLE_NAME, where, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int count;
        switch (sUriMatcher.match(uri)) {
            case HOMES:
                count = db.update(HOME_TABLE_NAME, values, selection, selectionArgs);
                break;
            case PROFILE_SETUPS:
                count = db.update(PROFILE_SETUP_TABLE_NAME,values,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
