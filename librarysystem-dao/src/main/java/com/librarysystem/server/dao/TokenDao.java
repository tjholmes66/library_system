package com.librarysystem.server.dao;

import java.util.List;

import com.librarysystem.server.domain.TokenEntity;

public interface TokenDao
{
    // CREATE
    TokenEntity create(TokenEntity tokenEntity);

    // RETRIEVE
    TokenEntity getById(long tokenId);

    TokenEntity getTokenEntityByUserId(long userId);

    TokenEntity getTokenEntityByUsername(String username);

    List<TokenEntity> getAllTokenEntityList();

    TokenEntity getTokenEntityByToken(String token);

    // UPDATE
    TokenEntity update(TokenEntity tokenEntity);

}
