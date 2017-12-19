package com.librarysystem.server.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.librarysystem.server.dto.LoginUserDTO;
import com.librarysystem.server.dto.RegisterUserDTO;
import com.librarysystem.server.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController
{
    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    // Register: This web service is invoked for during registration.
    // The user provides the following fields:
    // first name, last name, email, phone (optional), date of birth (optional).
    // Response will return a success status.
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody boolean registerUser(@RequestBody RegisterUserDTO registerUserDTO) throws Exception
    {
        boolean response = userService.register(registerUserDTO);
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody boolean registerUser(@RequestBody LoginUserDTO loginUserDto) throws Exception
    {
        boolean response = userService.login(loginUserDto);
        return response;
    }

}
