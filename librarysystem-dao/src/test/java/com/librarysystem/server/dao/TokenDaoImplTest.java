package com.librarysystem.server.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.librarysystem.server.domain.TokenEntity;
import com.librarysystem.server.domain.UserEntity;

public class TokenDaoImplTest extends BaseDaoTests
{
    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;

    protected void setUp() throws Exception
    {
        System.out.println("setup: Loading application context");
        System.out.println("setup: Done loading application context");
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
        System.out.println("tearDown: START");
        System.out.println("tearDown: FINISH");
    }

    private long _tokenId = 0;
    private long _userId = 1;
    private String _token = "fkasjfhl-ksdfhla-409724-flaskh";
    private LocalDateTime _created = LocalDateTime.now();

    private TokenEntity create()
    {
        TokenEntity tokenEntity = new TokenEntity();

        tokenEntity.setTokenId(_tokenId);

        UserEntity user = new UserEntity();
        user.setUserId(_userId);
        tokenEntity.setUser(user);

        tokenEntity.setToken(_token);

        tokenEntity.setCreated(_created);

        return tokenEntity;
    }

    // TokenEntity create(TokenEntity tokenEntity);
    @Test
    public void testTokenCreate()
    {
        System.out.println("testTokenCreate: START");

        TokenEntity tokenEntity = create();

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testTokenCreate: FINISH");
    }

    // TokenEntity updateTokenEntity(TokenEntity tokenEntity);
    @Test
    public void testTokenUpdate()
    {
        System.out.println("testTokenUpdate: START");

        TokenEntity tokenEntity = create();

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        String token = "upd-token-123456-abcd";
        tokenEntity.setToken(token);

        tokenEntity = tokenDao.update(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testTokenUpdate: FINISH");
    }

    // void deleteTokenEntity(long tokenId);
    // void deleteTokenEntity(TokenEntity tokenEntity);

    // TokenEntity getTokenEntity(long tokenId);
    @Test
    public void testGetTokenEntityById()
    {
        System.out.println("testGetTokenEntity: START");

        TokenEntity tokenEntity = create();

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        long tokenId = tokenEntity.getTokenId();
        tokenEntity = tokenDao.getById(tokenId);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testGetTokenEntity: FINISH");
    }

    // TokenEntity getTokenEntityByTokenname(String tokenname);
    @Test
    public void testGetTokenEntityByTokenUsername()
    {
        System.out.println("testGetTokenEntityByTokenUsername: START");

        TokenEntity tokenEntity = create();

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        String username = tokenEntity.getUser().getUsername();
        tokenEntity = tokenDao.getTokenEntityByUsername(username);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testGetTokenEntityByTokenUsername: FINISH");
    }

    @Test
    public void testGetTokenEntityByTokenUserId()
    {
        System.out.println("testGetTokenEntityByTokenUserId: START");

        TokenEntity tokenEntity = create();

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        long userId = tokenEntity.getUser().getUserId();
        tokenEntity = tokenDao.getTokenEntityByUserId(userId);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testGetTokenEntityByTokenUserId: FINISH");
    }

    // List<TokenEntity> getAllTokenEntityList();
    @Test
    public void testGetAllTokenEntityList()
    {
        System.out.println("testGetAllTokenEntityList: START");

        TokenEntity tokenEntity = create();

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        // ===================================================================

        List<TokenEntity> tokenList = tokenDao.getAllTokenEntityList();

        assertNotNull(tokenList);
        assertEquals(true, tokenList.size() > 0);

        System.out.println("testGetAllTokenEntityList: FINISH");
    }

    // TokenEntity getTokenEntityByTokenname(String tokenname);
    @Test
    public void testGetTokenEntityByTokenActiveUser()
    {
        System.out.println("testGetTokenEntityByTokenActiveUser: START");

        TokenEntity tokenEntity = create();
        tokenEntity.getUser().setEnabled(true);

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());
        assertEquals(true, tokenEntity.getUser().isEnabled());

        String token = tokenEntity.getToken();
        tokenEntity = tokenDao.getTokenEntityByToken(token);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());
        assertEquals(true, tokenEntity.getUser().isEnabled());

        System.out.println("testGetTokenEntityByTokenActiveUser: FINISH");
    }

    // TokenEntity getTokenEntityByTokenname(String tokenname);
    @Test
    public void testGetTokenEntityByTokenInActiveUser()
    {
        System.out.println("testGetTokenEntityByTokenInActiveUser: START");

        TokenEntity tokenEntity = create();

        // ====================================================
        UserEntity user = userDao.getById(_userId);
        user.setEnabled(false);
        user = userDao.update(user);
        // ====================================================
        tokenEntity.setUser(user);

        tokenEntity = tokenDao.create(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());
        assertEquals(false, tokenEntity.getUser().isEnabled());

        String token = tokenEntity.getToken();
        tokenEntity = tokenDao.getTokenEntityByToken(token);

        assertNull(tokenEntity);

        System.out.println("testGetTokenEntityByTokenInActiveUser: FINISH");
    }

}
