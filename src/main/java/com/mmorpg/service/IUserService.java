package com.mmorpg.service;

/**
 * author:ydx
 * create 2019\7\21 0021
 */

import com.mmorpg.pojo.User;


public interface IUserService {

    public User selectUser(long userId);

}
