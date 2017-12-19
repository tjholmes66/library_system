package com.librarysystem.server.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.librarysystem.server.domain.RoleEntity;
import com.librarysystem.server.domain.UserEntity;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService
{
    private static final Log logger = LogFactory.getLog(CustomUserDetailsService.class);

    // @Autowired
    // private TokenDao tokenDao;

    // @Autowired
    // private AuthTokenDTO authToken;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String webKey) throws UsernameNotFoundException
    {
        System.out.println("CustomUserDetailsService: loadUserByUsername: webKey: [" + webKey + "]");

        Object tokenEntity = null;
        System.out.println("CustomUserDetailsService: loadUserByUsername: tokenEntity: [" + tokenEntity + "]");

        if (tokenEntity == null)
        {
            System.out.println("CustomUserDetailsService: tokenEntity not found");
            throw new UsernameNotFoundException("Web Key not found");
        }

        UserEntity userEntity = null; // tokenEntity.getUser();
        System.out.println("CustomUserDetailsService: loadUserByUsername: userEntity: [" + userEntity + "]");
        if (userEntity == null)
        {
            System.out.println("CustomUserDetailsService: userEntity not found");
            throw new UsernameNotFoundException("Web Key not found");
        }
        else if (userEntity != null && !userEntity.isEnabled())
        {
            System.out.println("CustomUserDetailsService: userEntity not Active");
            throw new UsernameNotFoundException("User not Active");
        }

        System.out.println("CustomUserDetailsService: START: springframework.user");
        // this "User" object is: org.springframework.security.core.userdetails.User
        User user = new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnabled(), true, true, true, getGrantedAuthorities(userEntity));

        System.out.println("CustomUserDetailsService: loadUserByUsername: FINISH: springframework.user = " + user);
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