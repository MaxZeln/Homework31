package ru.learnup.learnup.spring.mvc.homework31.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.learnup.learnup.spring.mvc.homework31.roles.UserRoleForUser;

import java.util.Collection;
import java.util.List;

@Data
@Builder
public class UserWithRoles implements UserDetails {

    private final String login;
    private final String password;
    private final List<UserRoleForUser> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getLogin();
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

}
