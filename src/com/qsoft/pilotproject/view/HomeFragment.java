package com.qsoft.pilotproject.view;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.*;
import com.qsoft.pilotproject.R;
import com.qsoft.pilotproject.accountmanager.AccountGeneral;
import com.qsoft.pilotproject.adapter.ArrayFeedAdapter;
import com.qsoft.pilotproject.adapter.SideBarItemAdapter;
import com.qsoft.pilotproject.model.contentProvider.HomeContentProvider;
import com.qsoft.pilotproject.model.entity.Feed;
import com.qsoft.pilotproject.utils.Common;

import java.util.ArrayList;

/**
 * User: binhtv
 * Date: 10/14/13
 * Time: 10:47 AM
 */
public class HomeFragment extends FragmentActivity
{
    public static final String[] SIDE_BAR_ITEMS = new String[]{"Home", "Favorite", "Following", "Audience",
            "Genres", "Setting", "Help Center", "Sign Out"};
    public static final Integer[] SIDE_BAR_ICONS = new Integer[]{
            R.drawable.sidebar_imageicon_home,
            R.drawable.sidebar_image_icon_favorite,
            R.drawable.sidebar_image_icon_following,
            R.drawable.sidebar_image_icon_audience,
            R.drawable.sidebar_image_icon_genres,
            R.drawable.sidebar_image_icon_setting,
            R.drawable.sidebar_image_icon_helpcenter,
            R.drawable.sidebar_image_icon_logout
    };
    private ListView lvFeeds;
    private ListView lvSlideBar;
    private ImageView imProfile;
    private View drawerView;
    private DrawerLayout dlSlideBar;
    private AccountManager accountManager;
    private HomeContentProvider mDB;
    Button btMenu;
    Button btNotification;

    ArrayAdapter<Feed> adapter;
    private ArrayList<Feed> list;
    String[] columns = {Common.FEED_TITLE,Common.FEED_DISPLAY_NAME,Common.FEED_LIKES,Common.FEED_COMMENTS,Common.FEED_UPDATED_AT,Common.FEED_AVATAR};

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        lvFeeds = (ListView) findViewById(R.id.lvFeeds);
        accountManager = AccountManager.get(getApplicationContext());
        Account[] account = accountManager.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_FORCE, true);
        ContentResolver.setSyncAutomatically(account[0], HomeContentProvider.AUTHORITY, true);
        ContentResolver.requestSync(account[0], HomeContentProvider.AUTHORITY, bundle);

        final  ContentResolver contentResolver = getContentResolver();
        final Uri CONTENT_URI =
                Common.CONTENT_URI.buildUpon().appendPath("home").build();
        Cursor mCursor = contentResolver.query(CONTENT_URI,columns,null,null,null);
        imProfile = (ImageView)findViewById(R.id.imProfile);
        list = new ArrayList<Feed>();
        if(mCursor.moveToFirst()){
            do{
                Feed feed = new Feed();
                feed.setTitle(mCursor.getString(0));
                feed.setDisplay_name(mCursor.getString(1));
                feed.setLikeNumber(Integer.parseInt(mCursor.getString(2)));
                feed.setCommentNumber(Integer.parseInt(mCursor.getString(3)));
                feed.setUpdateStatus(mCursor.getString(4));
                list.add(feed);
            }while (mCursor.moveToNext());
        }
        ArrayFeedAdapter arrayFeedAdapter = new ArrayFeedAdapter(this, list);
        lvFeeds.setAdapter(arrayFeedAdapter);

        dlSlideBar = (DrawerLayout) findViewById(R.id.drawer_layout);
        lvSlideBar = (ListView) findViewById(R.id.lvSlideBar);
        drawerView = findViewById(R.id.left_drawer);
        setListViewSlideBar();
        lvSlideBar.setOnItemClickListener(itemSideBarClickListener);
        lvFeeds.setOnItemClickListener(feedClickListener);
        btMenu = (Button) findViewById(R.id.btMenu);
        btMenu.setOnClickListener(btMenuClickListener);
        btNotification = (Button)findViewById(R.id.btNotification);
        btNotification.setOnClickListener(btNotificationListener);

    }
    View.OnClickListener btNotificationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomeFragment.this, ProfileSetupFragment.class);
            startActivity(intent);
        }
    };

    AdapterView.OnItemClickListener feedClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Intent intent = new Intent(HomeFragment.this,ProgramFragment.class);
            startActivity(intent);
        }
    };

    AdapterView.OnItemClickListener itemSideBarClickListener = new AdapterView.OnItemClickListener()
    {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            // on item click
        }
    };

    public View.OnClickListener btMenuClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            dlSlideBar.openDrawer(drawerView);
        }
    };

    public void setListViewSlideBar()
    {
        SideBarItemAdapter sideBarItemAdapter = new SideBarItemAdapter(this, R.layout.menu, SIDE_BAR_ITEMS);
        lvSlideBar.setAdapter(sideBarItemAdapter);
    }
}