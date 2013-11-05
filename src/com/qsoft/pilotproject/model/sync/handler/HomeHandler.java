package com.qsoft.pilotproject.model.sync.handler;

import com.qsoft.pilotproject.model.entity.Home;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhTran
 * Date: 11/4/13
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
public interface HomeHandler {
    public List<Home> getHomes(String authenToken);
}
