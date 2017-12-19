package com.librarysystem.server.service;

import java.util.List;

import com.librarysystem.server.domain.UserEntity;
import com.librarysystem.server.dto.LoginUserDTO;
import com.librarysystem.server.dto.RegisterUserDTO;

public interface UserService
{
    // CREATE
    UserEntity create(UserEntity userEntity);

    boolean register(RegisterUserDTO registerUserDTO);

    // RETRIEVE
    UserEntity getById(long userId);

    UserEntity getUserEntityByUsername(String username);

    List<UserEntity> getAllUserEntityList();

    UserEntity getUserByUsernameAndPassword(String username, String password);

    UserEntity getUserByResetKey(String resetKey);

    UserEntity getUserByEmailAddress(String emailAddress);

    boolean login(LoginUserDTO loginUserDto);

    // UPDATE
    UserEntity update(UserEntity userEntity);

}
