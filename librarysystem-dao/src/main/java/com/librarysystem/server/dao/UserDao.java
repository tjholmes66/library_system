package com.librarysystem.server.dao;

import java.util.List;

import com.librarysystem.server.domain.UserEntity;


public interface UserDao
{
    // CREATE
    UserEntity create(UserEntity userEntity);

    // RETRIEVE
    UserEntity getById(long userId);

    UserEntity getUserEntityByUsername(String username);

    List<UserEntity> getAllUserEntityList();

    UserEntity getUserByUsernameAndPassword(String username, String password);

    UserEntity getUserByResetKey(String resetKey);

    UserEntity getUserByEmailAddress(String emailAddress);


    // UPDATE
    UserEntity update(UserEntity userEntity);

}
