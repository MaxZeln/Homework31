package ru.learnup.learnup.spring.mvc.homework31.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.learnup.learnup.spring.mvc.homework31.entity.User;
import ru.learnup.learnup.spring.mvc.homework31.repository.UserRepository;

import java.util.Collections;


@Slf4j
//@Component
public class AuthProvider implements AuthenticationProvider {

    private final UserRepository repository;

    public AuthProvider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        log.info("login: {}, password: {}", name, password);

        User user = repository.getUserByNickname(name);

        if (user == null) {
            throw  new UsernameNotFoundException("User with login: " + name + " not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("wrong password");
        }

        System.out.println("roles: " + user.getUserRole());

        return new UsernamePasswordAuthenticationToken(user, password, Collections.singleton(user.getUserRole()));
    }


    //    private final UserWithRolesRepository repository;
//
//    public AuthProvider(UserWithRolesRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String name = authentication.getName();
//        String password = String.valueOf(authentication.getCredentials());
//        log.info("login: {}, password: {}", name, password);
//
//        UserWithRoles user = repository.getUserByLogin(name);
//
//        if (user == null) {
//            throw  new UsernameNotFoundException("User with login: " + name + " not found");
//        }
//        if (!user.getPassword().equals(password)) {
//            throw new BadCredentialsException("wrong password");
//        }
//
//        return new UsernamePasswordAuthenticationToken(user, password, user.getRoles());
//    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
