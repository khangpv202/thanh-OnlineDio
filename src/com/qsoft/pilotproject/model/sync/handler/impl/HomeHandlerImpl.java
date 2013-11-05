package com.qsoft.pilotproject.model.sync.handler.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qsoft.pilotproject.model.entity.Home;
import com.qsoft.pilotproject.model.sync.handler.HomeHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhTran
 * Date: 11/4/13
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class HomeHandlerImpl implements HomeHandler {
    @Override
    public List<Home> getHomes(String authenToken) {
        List<Home> listHome = new ArrayList<Home>();
        String responseString = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "http://192.168.1.222/testing/ica467/trunk/public/home-rest";
        String requestQuery = null;
        int limit = 20;
        requestQuery = String.format("limit=%s&offset=%s&time_from=%s&time_to=%s", limit, "", "", "");
        url = url + "?" + requestQuery;
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Authorization", "Bearer " + authenToken);
        JSONObject jsonObject = new JSONObject();
        try
        {
            HttpResponse response = httpClient.execute(httpGet);
            responseString = EntityUtils.toString(response.getEntity());
            jsonObject = new JSONObject(responseString);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Home>>(){}.getType();
            listHome = gson.fromJson(jsonObject.getString("data").toString(),type);
            return listHome;
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
