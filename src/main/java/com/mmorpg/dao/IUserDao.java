package com.mmorpg.dao;

import com.mmorpg.pojo.User;

/**
 * author:ydx
 * create 2019\7\21 0021
 */
public interface IUserDao {

    User selectUser(long id);

}