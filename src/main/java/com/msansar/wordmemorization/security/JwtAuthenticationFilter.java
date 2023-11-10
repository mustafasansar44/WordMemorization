package com.msansar.wordmemorization.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msansar.wordmemorization.model.Role;
import com.msansar.wordmemorization.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// Sadece /login endpoint'inde çalışıyor bu filtre unutma!!!!
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter { // AuthenticationFilter

    private final AuthenticationManager authenticationManager;
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UsernamePasswordAuthenticationToken authRequest = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
            this.setDetails(request, authRequest);
            return authenticationManager.authenticate(authRequest);

        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        CustomUserDetail userDetail = (CustomUserDetail) authResult.getPrincipal();
        List<Role> roles = (List<Role>) userDetail.getAuthorities();
        User user = new User(userDetail.getUsername(), userDetail.getPassword(), roles);

        String accessToken = TokenService.createToken(user);
        String refreshToken = TokenService.createToken(user);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), Map.of(
                "access_token", accessToken,
                "refresh_token", refreshToken
        ));
    }
}
