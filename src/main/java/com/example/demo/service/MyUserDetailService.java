package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName MyUserDetailService
 * @Description TODO
 * @Author WangZhe
 * @Date 2022/4/14 15:43
 * @Version 1.0
 */

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<com.example.demo.entity.User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        com.example.demo.entity.User user = userMapper.selectOne(userQueryWrapper);
        if(user == null) {
            throw new UsernameNotFoundException("没有改用户");
        }


        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_consumer,ROLE_producer");
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()),authorities);
    }
}
