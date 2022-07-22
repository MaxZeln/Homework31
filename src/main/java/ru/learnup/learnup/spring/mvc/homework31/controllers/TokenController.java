package ru.learnup.learnup.spring.mvc.homework31.controllers;

import ru.learnup.learnup.spring.mvc.homework31.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.learnup.learnup.spring.mvc.homework31.filters.JwtAuthorizationFilter.getToken;

@RestController
public class TokenController {

    private final JwtService jwtService;
    private final UserDetailsService userService;

    @Autowired
    public TokenController(JwtService jwtService, UserDetailsService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping("/api/tokenRefresh")
    public void auth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = getToken(request);
        String username = null;

        if ( token != null) {
             username = jwtService.getUserFromRefreshToken(token);
             if (username != null) {
                  final UserDetails user = userService.loadUserByUsername(username);
                  if (user != null) {
                      final String accessToken = jwtService.generateAccessToken(request.getRequestURI(), user);
                      final String refreshToken = jwtService.generateRefreshToken(request.getRequestURI(), user);
                      response.setHeader("access_token", accessToken);
                      response.setHeader("refresh_token", refreshToken);
                      return;
                  }
             }
        }

        response.sendRedirect("/api/auth");
    }
}
