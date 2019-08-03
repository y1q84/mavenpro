package com.mmorpg.service.impl;

/**
 * author:ydx
 * create 2019\7\21 0021
 */

import com.mmorpg.dao.IUserDao;
import com.mmorpg.pojo.User;
import com.mmorpg.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
