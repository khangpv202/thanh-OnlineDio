package com.qsoft.pilotproject.model.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.qsoft.pilotproject.accountmanager.AccountGeneral;
import com.qsoft.pilotproject.model.entity.Home;
import com.qsoft.pilotproject.model.sync.handler.HomeHandler;
import com.qsoft.pilotproject.model.sync.handler.impl.HomeHandlerImpl;
import com.qsoft.pilotproject.utils.Common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhTran
 * Date: 11/4/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {
    private static final String TAG = "SyncAdapter";
    private final Context context;
    private final AccountManager accountManager;

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        this.context = context;
        accountManager = AccountManager.get(context);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        try{
            String authenToken = accountManager.blockingGetAuthToken(account, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS,true);
            HomeHandler homeHandler = new HomeHandlerImpl();
            List<Home> serviceListHomes = homeHandler.getHomes(authenToken);
            List<Home> localListHomes = new ArrayList<Home>();

            final Uri CONTENT_URI =
                    Common.CONTENT_URI.buildUpon().appendPath("home").build();

            Cursor cursor = provider.query(CONTENT_URI, null, null, null, null);
            if (cursor != null)
            {
                cursor.moveToFirst();
                while (cursor.moveToNext())
                {
                    // get data from cursor add into local list
                    localListHomes.add(Home.fromCursor(cursor));
                }
                cursor.close();
            }

            //update to local
            ArrayList<Home> updateLocal = new ArrayList<Home>();
            for(Home homeDTO : serviceListHomes){
                if(!localListHomes.contains(homeDTO)){
                    updateLocal.add(homeDTO);
                }
            }
            if(updateLocal.size() == 0){
                Log.d(TAG, "No data change from server");
            }
            else {
                Log.d(TAG, "update local database from server");
                int i = 0;
                ContentValues homeContentValues[] = new ContentValues[updateLocal.size()];
                for(Home homeDTO : updateLocal){
                    homeContentValues[i++] = homeDTO.getContentValues();
                }
                //persist to database local
                provider.bulkInsert(CONTENT_URI, homeContentValues);
            }
            Log.d(TAG, "sync finished");
        }
        catch (AuthenticatorException e) {
            e.printStackTrace();
        } catch (OperationCanceledException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
