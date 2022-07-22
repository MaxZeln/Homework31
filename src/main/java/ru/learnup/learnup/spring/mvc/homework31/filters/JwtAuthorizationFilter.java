package ru.learnup.learnup.spring.mvc.homework31.filters;

import ru.learnup.learnup.spring.mvc.homework31.jwt.JwtService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    public static final String TOKEN_PREFIX = "Bearer ";
    private final JwtService jwtService;

    public JwtAuthorizationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public static String getToken(HttpServletRequest request) {
        final String authHeader = request.getHeader(AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            return authHeader.substring((TOKEN_PREFIX.length()));
        }
        return null;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        final String servletPath = request.getServletPath();
        if (!servletPath.equals("/api/auth") && !servletPath.equals("/api/tokenRefresh")) {
            String token = getToken(request);

            if (token != null) {
                jwtService.verify(token);
            }
        }

        filterChain.doFilter(request, response);
    }
}
