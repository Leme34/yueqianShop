package com.lee.yueqian.dao.impl;

import com.lee.yueqian.bean.Users;
import com.lee.yueqian.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * UsersDao接口相关操作
 */

@Service
public class UsersDaoImpl{
    @Autowired
    UsersMapper usersDao;

    /**
     * 查询用户名是否已被使用
     * 返回true则已被使用,false则未被使用
     */
    public boolean isUsed(String username){
        Users users = usersDao.selectByPrimaryKey(username);
        //未被使用
        if (users==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 根据username查询返回用户密码
     */
    public String getPassword(String username){
        Users users = usersDao.selectByPrimaryKey(username);
        //若数据库无此用户名
        if(users==null){
            return null;
        }else { //查询成功
            return users.getPassword();
        }
    }

    /**
     * 保存用户名密码到数据库,返回受影响行数
     */
    public int saveUser(String username,String password){
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        return usersDao.insert(users);
    }
}
