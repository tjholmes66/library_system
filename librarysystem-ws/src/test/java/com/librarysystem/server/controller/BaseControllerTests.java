package com.librarysystem.server.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.librarysystem.server.dao.UserDao;
import com.librarysystem.server.domain.RoleEntity;
import com.librarysystem.server.domain.UserEntity;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations =
{
    "classpath:/spring/librarysystem-ws-context.xml",

    "file:src/main/webapp/WEB-INF/springmvc-servlet.xml",

    "file:src/main/webapp/WEB-INF/spring-security.xml" })

@Transactional
public class BaseControllerTests extends TestCase
{

    public final static String BASE_URL = "http://localhost:8080/";

    public final static String JSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public final static SimpleDateFormat sdfJson = new SimpleDateFormat(JSON_DATE_FORMAT);

    public final static String DATE_FORMAT = "yyyy-MM-dd";
    // public final static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    public final static DateTimeFormatter sdf = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Autowired
    protected WebApplicationContext ctx;

    @Autowired
    protected Filter springSecurityFilterChain;

    protected MockMvc mockMvc;

    protected MockHttpSession session;

    @Autowired
    private UserDao userDao;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    private String _tholmesUsername = "tholmes";
    public User _userTholmesAdmin = null;

    private String _jsmithUsername = "jsmith";
    public User _userJSmithUser = null;

    @Before
    public void setUp()
    {
        this.session = new MockHttpSession();
        _userTholmesAdmin = createAuthenticatedUser1(_tholmesUsername);
        _userJSmithUser = createAuthenticatedUser1(_jsmithUsername);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).addFilters(springSecurityFilterChain).build();
    }

    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    public static final ObjectMapper makeMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParameterNamesModule());
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    public byte[] getByteArrayFromFile(String filename)
    {
        FileInputStream fileInputStream = null;

        File file = new File(filename);

        byte[] bFile = new byte[(int) file.length()];

        try
        {
            // convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

            for (int i = 0; i < bFile.length; i++)
            {
                System.out.print((char) bFile[i]);
            }

            System.out.println("Done");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bFile;
    }

    public User createAuthenticatedUser1(String username)
    {
        UserEntity userEntity = userDao.getUserEntityByUsername(username);

        List<GrantedAuthority> authorities = getGrantedAuthorities(userEntity);

        User user = new User(userEntity.getUsername(), userEntity.getPassword(), false, false, false, false, authorities);
        return user;
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserEntity userEntity)
    {
        System.out.println("getGrantedAuthorities: START");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        List<RoleEntity> userRoleList = new ArrayList<RoleEntity>();
        userRoleList.add(userEntity.getRole());

        for (RoleEntity role : userRoleList)
        {
            System.out.println("getGrantedAuthorities: role : " + role);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleCode()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
