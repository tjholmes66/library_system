package com.librarysystem.server.service;

import java.time.LocalDate;
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
import com.librarysystem.server.dao.TokenDao;
import com.librarysystem.server.dao.UserDao;
import com.librarysystem.server.domain.BookEntity;
import com.librarysystem.server.domain.RoleEntity;
import com.librarysystem.server.domain.TokenEntity;
import com.librarysystem.server.domain.UserEntity;
import com.librarysystem.server.dto.BookDTO;
import com.librarysystem.server.dto.LoginResponseDTO;
import com.librarysystem.server.dto.LoginUserDTO;
import com.librarysystem.server.dto.RegisterUserDTO;
import com.librarysystem.server.util.ShortUUID;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

    private static final int CHECKOUT_TIME = 14;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TokenDao tokenDao;

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
    public LoginResponseDTO login(LoginUserDTO loginUserDto)
    {
        LoginResponseDTO loginResponseDto = new LoginResponseDTO();

        String username = loginUserDto.getUsername();
        String password = loginUserDto.getPassword();
        UserEntity user = userDao.getUserByUsernameAndPassword(username, password);

        LocalDate today = LocalDate.now();

        List<BookDTO> bookDtoList = new ArrayList<BookDTO>();
        if (user != null)
        {
            // ============================================================================
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setCreated(LocalDateTime.now());
            tokenEntity.setToken(ShortUUID.shortUUID());
            tokenEntity.setUser(user);
            tokenEntity = tokenDao.create(tokenEntity);
            // ============================================================================
            loginResponseDto.setToken(tokenEntity.getToken());

            List<BookEntity> bookList = bookDao.getBooksByUserId(user.getUserId());
            for (BookEntity book : bookList)
            {
                BookDTO bookDto = new BookDTO();
                bookDto.setBook(book);
                bookDto.setUser(user);

                LocalDate dueDate = book.getCheckedOutDate().plusDays(CHECKOUT_TIME);
                bookDto.setDueDate(dueDate);

                boolean overDue = dueDate.isBefore(today);
                bookDto.setOverdue(overDue);

                bookDtoList.add(bookDto);
            }
            loginResponseDto.setBookList(bookDtoList);

        }

        return loginResponseDto;
    }

}
