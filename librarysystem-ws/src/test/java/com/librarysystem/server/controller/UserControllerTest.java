package com.librarysystem.server.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.librarysystem.server.dto.LoginUserDTO;

public class UserControllerTest extends BaseControllerTests
{
    private final static String BASE_URL = "/users";

    @Before
    public void setup()
    {
    }

    @Test
    public void testMockRegisterUser1() throws Exception
    {
        // has all fields
        String filename = "src/test/resources/json/user/register_user1.json";
        byte[] data = getByteArrayFromFile(filename);
        String json = new String(data);
        System.out.println("testMockRegisterUser: json=" + json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/register").contentType(MediaType.APPLICATION_JSON).content(json);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockRegisterUser2() throws Exception
    {
        // has all fields
        String filename = "src/test/resources/json/user/register_user2.json";
        byte[] data = getByteArrayFromFile(filename);
        String json = new String(data);
        System.out.println("testMockRegisterUser: json=" + json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/register").contentType(MediaType.APPLICATION_JSON).content(json);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockRegisterUser3() throws Exception
    {
        // has all fields
        String filename = "src/test/resources/json/user/register_user3.json";
        byte[] data = getByteArrayFromFile(filename);
        String json = new String(data);
        System.out.println("testMockRegisterUser: json=" + json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/register").contentType(MediaType.APPLICATION_JSON).content(json);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockLoginSuccessWithBooks() throws Exception
    {
        // user DOES exist, can find based on username/password
        String username = "tholmes";
        String password = "password";
        LoginUserDTO loginUserDto = new LoginUserDTO();
        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        String json = makeMapper().writeValueAsString(loginUserDto);
        System.out.println("testMockLoginSuccessWithBooks: json=" + json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/login").contentType(MediaType.APPLICATION_JSON).content(json);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockLoginSuccessWithoutBooks() throws Exception
    {
        // user DOES exist, can find based on username/password
        String username = "jsmith";
        String password = "password";
        LoginUserDTO loginUserDto = new LoginUserDTO();
        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        String json = makeMapper().writeValueAsString(loginUserDto);
        System.out.println("testMockLoginSuccessWithBooks: json=" + json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/login").contentType(MediaType.APPLICATION_JSON).content(json);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockLoginFailure() throws Exception
    {
        // user DOES exist, can find based on username/password
        String username = "xxxx";
        String password = "yyyyy";
        LoginUserDTO loginUserDto = new LoginUserDTO();
        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        String json = makeMapper().writeValueAsString(loginUserDto);
        System.out.println("testMockLoginSuccessWithBooks: json=" + json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/login").contentType(MediaType.APPLICATION_JSON).content(json);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
