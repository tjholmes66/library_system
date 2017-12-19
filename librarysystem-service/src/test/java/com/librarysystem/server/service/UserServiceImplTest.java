package com.librarysystem.server.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.librarysystem.server.domain.RoleEntity;
import com.librarysystem.server.domain.UserEntity;
import com.librarysystem.server.dto.LoginResponseDTO;
import com.librarysystem.server.dto.LoginUserDTO;
import com.librarysystem.server.dto.RegisterUserDTO;

public class UserServiceImplTest extends BaseServiceTests
{
    @Autowired
    private UserService userService;

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

    private long _userId = 0;
    private String _username = "test";
    private String _password = "7lQc2WBN2qYrBYwg9ZW7WIoHfD6b1kLTRrQBEzqE3qY=$2j15h6Hwq78amEU5aubuCvVD/2p3Xr3RfaASHW6ULyk=";
    private String _emailAddress = "tom@tomholmes.xyz";
    private boolean _userActive = true;
    private String _userFirstName = "test_FN";
    private String _userLastName = "test_LN";
    private long _editedBy = 1;
    private long _enteredBy = 1;
    private LocalDateTime _editedDate = LocalDateTime.now();
    private LocalDateTime _enteredDate = LocalDateTime.now();
    private long _roleId = 2; // user

    private UserEntity create()
    {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(_userId);

        userEntity.setUsername(_username);
        userEntity.setPassword(_password);

        userEntity.setEnabled(_userActive);
        userEntity.setEmailAddress(_emailAddress);

        userEntity.setFirstName(_userFirstName);
        userEntity.setLastName(_userLastName);

        // =====================================================

        RoleEntity role = new RoleEntity();
        role.setRoleId(_roleId);
        userEntity.setRole(role);

        // =====================================================

        userEntity.setEditedBy(_editedBy);
        userEntity.setEditedDate(_editedDate);
        userEntity.setEnteredBy(_enteredBy);
        userEntity.setEnteredDate(_enteredDate);

        return userEntity;
    }

    // UserEntity create(UserEntity userEntity);
    @Test
    public void testUserCreate()
    {
        System.out.println("testUserCreate: START");

        UserEntity userEntity = create();

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        System.out.println("testUserCreate: FINISH");
    }

    // UserEntity updateUserEntity(UserEntity userEntity);
    @Test
    public void testUserUpdate()
    {
        System.out.println("testUserUpdate: START");

        UserEntity userEntity = create();

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        String username = "updated";
        String password = "new_password";
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        userEntity = userService.update(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(username, userEntity.getUsername());
        assertEquals(password, userEntity.getPassword());

        System.out.println("testUserUpdate: FINISH");
    }

    // void deleteUserEntity(long userId);
    // void deleteUserEntity(UserEntity userEntity);

    // UserEntity getUserEntity(long userId);
    @Test
    public void testGetUserEntityById()
    {
        System.out.println("testGetUserEntity: START");

        UserEntity userEntity = create();

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        long userId = userEntity.getUserId();
        userEntity = userService.getById(userId);

        assertNotNull(userEntity);
        assertEquals(userId, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        System.out.println("testGetUserEntity: FINISH");
    }

    // UserEntity getUserEntityByUsername(String username);
    @Test
    public void testGetUserEntityByUsername()
    {
        System.out.println("testGetUserEntityByUsername: START");

        UserEntity userEntity = create();

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        String username = userEntity.getUsername();
        userEntity = userService.getUserEntityByUsername(username);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        System.out.println("testGetUserEntityByUsername: FINISH");
    }

    // List<UserEntity> getAllUserEntityList();
    @Test
    public void testGetAllUserEntityList()
    {
        System.out.println("testGetAllUserEntityList: START");

        List<UserEntity> userList = userService.getAllUserEntityList();

        assertNotNull(userList);
        assertEquals(true, userList.size() > 0);

        System.out.println("testGetAllUserEntityList: FINISH");
    }

    // UserEntity getUserByUsernameAndPassword(String username, String password);
    @Test
    public void testGetUserEntityByUsernameAndPassword()
    {
        System.out.println("testGetUserEntityByUsernameAndPassword: START");

        UserEntity userEntity = create();

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        userEntity = userService.getUserByUsernameAndPassword(username, password);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(username, userEntity.getUsername());
        assertEquals(password, userEntity.getPassword());

        System.out.println("testGetUserEntityByUsernameAndPassword: FINISH");
    }

    @Test
    public void testGetUserEntityByResetKey()
    {
        System.out.println("testGetUserEntityByResetKey: START");

        UserEntity userEntity = create();

        String resetKey = "ABCDEF-123456-ABCDEFG-7890";
        userEntity.setResetKey(resetKey);

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(resetKey, userEntity.getResetKey());

        resetKey = userEntity.getResetKey();
        userEntity = userService.getUserByResetKey(resetKey);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(resetKey, userEntity.getResetKey());

        System.out.println("testGetUserEntityByResetKey: FINISH");
    }

    @Test
    public void testGetUserEntityByEmailAddress()
    {
        System.out.println("testGetUserEntityByEmailAddress: START");

        UserEntity userEntity = create();

        userEntity = userService.create(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(_emailAddress, userEntity.getEmailAddress());

        String emailAddress = userEntity.getEmailAddress();
        userEntity = userService.getUserByEmailAddress(emailAddress);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(emailAddress, userEntity.getEmailAddress());

        System.out.println("testGetUserEntityByEmailAddress: FINISH");
    }

    @Test
    public void testRegisterUser1()
    {
        System.out.println("testRegisterUser: START");

        RegisterUserDTO registerUserDto = new RegisterUserDTO();

        String firstName = "first_name";
        String lastName = "last_name";
        String email = "test@email.com";
        String phone = "123-456-7890";

        registerUserDto.setDob(LocalDate.now());
        registerUserDto.setEmail(email);
        registerUserDto.setFirstName(firstName);
        registerUserDto.setLastName(lastName);
        registerUserDto.setPhone(phone);

        boolean success = userService.register(registerUserDto);
        assertEquals(true, success);

        registerUserDto.setFirstName(null);
        success = userService.register(registerUserDto);
        assertEquals(false, success);
        registerUserDto.setFirstName("");
        success = userService.register(registerUserDto);
        assertEquals(false, success);

        firstName = "first_name";
        registerUserDto.setFirstName(firstName);
        registerUserDto.setLastName(null);
        success = userService.register(registerUserDto);
        assertEquals(false, success);
        registerUserDto.setLastName("");
        success = userService.register(registerUserDto);
        assertEquals(false, success);

        lastName = "last_name";
        registerUserDto.setLastName(lastName);
        registerUserDto.setEmail(null);
        success = userService.register(registerUserDto);
        assertEquals(false, success);
        registerUserDto.setEmail("");
        success = userService.register(registerUserDto);
        assertEquals(false, success);

        firstName = "first_nameX";
        lastName = "last_nameX";
        email = "testX@emailX.com";

        registerUserDto.setFirstName(firstName);
        registerUserDto.setLastName(lastName);
        registerUserDto.setEmail(email);
        registerUserDto.setPhone(null);
        registerUserDto.setDob(null);

        // should be true becauuse first, last, and email are there
        // abd phone and dob are optional
        success = userService.register(registerUserDto);
        assertEquals(true, success);
    }

    @Test
    public void testRegisterUser2()
    {
        System.out.println("testRegisterUser: START");

        RegisterUserDTO registerUserDto = new RegisterUserDTO();

        String firstName = "first_name";
        String lastName = "last_name";
        String email = "test@email.com";

        registerUserDto.setFirstName(firstName);
        registerUserDto.setLastName(lastName);
        registerUserDto.setEmail(email);

        boolean success = userService.register(registerUserDto);
        assertEquals(true, success);
    }

    @Test
    public void testRegisterUser3()
    {
        System.out.println("testRegisterUser: START");

        RegisterUserDTO registerUserDto = new RegisterUserDTO();

        String lastName = "last_name";
        String email = "test@email.com";

        registerUserDto.setLastName(lastName);
        registerUserDto.setEmail(email);

        // should be false because missing first name
        boolean success = userService.register(registerUserDto);
        assertEquals(false, success);
    }

    @Test
    public void testLogin_Success()
    {
        // user DOES exist, can find based on username/password
        String username = "tholmes";
        String password = "password";
        LoginUserDTO loginUserDto = new LoginUserDTO();
        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        LoginResponseDTO loginResponseDto = userService.login(loginUserDto);
        assertNotNull(loginResponseDto);
        System.out.println("loginResponseDto = " + loginResponseDto.toString());
    }

    @Test
    public void testLogin_Success_NoBooks()
    {
        // user DOES exist, can find based on username/password
        String username = "jsmith";
        String password = "password";
        LoginUserDTO loginUserDto = new LoginUserDTO();
        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        LoginResponseDTO loginResponseDto = userService.login(loginUserDto);
        assertNotNull(loginResponseDto);
        System.out.println("loginResponseDto = " + loginResponseDto.toString());
    }

    @Test
    public void testLogin_Failure()
    {
        // user does NOT exist, cannot find based on username/password
        String username = "tholmesX";
        String password = "passwordX";
        LoginUserDTO loginUserDto = new LoginUserDTO();
        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        LoginResponseDTO loginResponseDto = userService.login(loginUserDto);
        assertNotNull(loginResponseDto);
        System.out.println("loginResponseDto = " + loginResponseDto.toString());
    }

}
