package com.librarysystem.server.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.librarysystem.server.dao.BookDao;
import com.librarysystem.server.dao.UserDao;
import com.librarysystem.server.domain.BookEntity;
import com.librarysystem.server.domain.RoleEntity;
import com.librarysystem.server.domain.UserEntity;
import com.librarysystem.server.dto.LoginUserDTO;
import com.librarysystem.server.dto.RegisterUserDTO;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

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

    @Override
    public boolean register(RegisterUserDTO registerUserDto)
    {
        boolean response = false;

        String firstName = registerUserDto.getFirstName();
        String lastName = registerUserDto.getLastName();
        String email = registerUserDto.getEmail();

        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName) && !StringUtils.isEmpty(email))
        {

            UserEntity userEntity = new UserEntity();

            userEntity.setUsername(firstName + lastName);

            // get properties from RegisterUserDTO
            userEntity.setFirstName(firstName);
            userEntity.setLastName(lastName);
            userEntity.setEmailAddress(email);
            userEntity.setCellPhone(registerUserDto.getPhone()); // optional
            userEntity.setDob(registerUserDto.getDob()); // optional

            // Set System properties
            LocalDateTime today = LocalDateTime.now();
            userEntity.setEditedBy(1);
            userEntity.setEditedDate(today);
            userEntity.setEnteredBy(1);
            userEntity.setEnteredDate(today);

            userEntity.setEnabled(true);

            // Set Role Properties - 2 is normal User, not Admin
            RoleEntity role = new RoleEntity();
            role.setRoleId(2);
            userEntity.setRole(role);

            userEntity = userDao.create(userEntity);
            if (userEntity != null)
            {
                response = true;
            }
        }

        return response;
    }

    @Override
    public List<BookEntity> login(LoginUserDTO loginUserDto)
    {
        String username = loginUserDto.getUsername();
        String password = loginUserDto.getPassword();
        UserEntity user = userDao.getUserByUsernameAndPassword(username, password);

        List<BookEntity> bookList = new ArrayList<BookEntity>();
        if (user != null)
        {
            bookList = bookDao.getBooksByUser(user.getUserId());
        }

        return bookList;
    }

}
