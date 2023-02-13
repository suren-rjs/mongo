package com.start.mongo.service;

import com.start.mongo.model.document.Roles;
import com.start.mongo.model.document.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@SuppressWarnings("All")
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private User user;
    private Roles roles;

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return roles.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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

    public String getUserId() {
        return user.getId();
    }
}

