package com.librarysystem.server.service;

import java.util.List;

import com.librarysystem.server.domain.UserEntity;

public interface UserService
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
