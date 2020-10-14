package com.yaoyuan.jiscuss.service.impl;

import com.yaoyuan.jiscuss.entity.UserInfo;
import com.yaoyuan.jiscuss.entity.User;
import com.yaoyuan.jiscuss.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.service.impl
 * @Description:
 * @date 2020/7/15 16:34
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IUsersService userInfoService;

    /**
     * 需新建配置类注册一个指定的加密方式Bean，或在下一步Security配置类中注册指定
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过用户名从数据库获取用户信息
        User userInfo = userInfoService.getByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 得到用户角色
        String role = "admin";

        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new UserInfo(
                authorities,
                userInfo.getId(),
                // 因为数据库是明文，所以这里需加密密码
                passwordEncoder.encode(userInfo.getPassword()),
                userInfo.getUsername(),
                userInfo.getPhone()
        );
    }
}