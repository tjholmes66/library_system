package com.librarysystem.server.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class RoleControllerTest extends BaseControllerTests
{
    private final static String BASE_URL = "/roles";

    @Test
    public void testMockGetAllRoles1() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL).with(user("tholmes").roles("ADMIN"));
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockGetAllRoles2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/").with(user("tholmes").roles("ADMIN"));
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
