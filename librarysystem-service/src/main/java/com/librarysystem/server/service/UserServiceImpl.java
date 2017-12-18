package com.librarysystem.server.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.librarysystem.server.dao.UserDao;
import com.librarysystem.server.domain.UserEntity;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity create(UserEntity userEntity)
    {
        UserEntity user = userDao.create(userEntity);
        return user;
    }

    @Override
    public UserEntity getById(long userId)
    {
        UserEntity user = userDao.getById(userId);
        return user;
    }

    @Override
    public UserEntity getUserEntityByUsername(String username)
    {
        UserEntity user = userDao.getUserEntityByUsername(username);
        return user;
    }

    @Override
    public List<UserEntity> getAllUserEntityList()
    {
        List<UserEntity> userList = userDao.getAllUserEntityList();
        return userList;
    }

    @Override
    public UserEntity getUserByUsernameAndPassword(String username, String password)
    {
        UserEntity user = userDao.getUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public UserEntity getUserByResetKey(String resetKey)
    {
        UserEntity user = userDao.getUserByResetKey(resetKey);
        return user;
    }

    @Override
    public UserEntity getUserByEmailAddress(String emailAddress)
    {
        UserEntity user = userDao.getUserByEmailAddress(emailAddress);
        return user;
    }

    @Override
    public UserEntity update(UserEntity userEntity)
    {
        UserEntity user = userDao.update(userEntity);
        return user;
    }

}
