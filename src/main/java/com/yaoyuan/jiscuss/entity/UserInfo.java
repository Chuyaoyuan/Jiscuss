package com.yaoyuan.jiscuss.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.entity
 * @Description:
 * @date 2020/7/16 14:55
 */
@Data
public class UserInfo implements UserDetails{

        private Collection<GrantedAuthority> authorities;
        private String password;
        private String username;
        private String phone;
        private Integer age;
        private Integer id;
        private String realname;
        private String email;
        private String gender;
        private Integer level;
        private Integer flag;

        public UserInfo() {
        }

        public UserInfo(Collection<GrantedAuthority> authorities, Integer id, String password, String username, String phone) {
            this.authorities = authorities;
            this.id = id;
            this.password = password;
            this.username = username;
            this.phone = phone;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "authorities=" + authorities +
                    ", password='" + password + '\'' +
                    ", username='" + username + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
}

