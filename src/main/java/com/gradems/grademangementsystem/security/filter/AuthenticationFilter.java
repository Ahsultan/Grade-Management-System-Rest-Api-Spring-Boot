package com.gradems.grademangementsystem.security.filter;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradems.grademangementsystem.entity.User;
import com.gradems.grademangementsystem.security.SecurityConstants;
import com.gradems.grademangementsystem.security.manager.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private CustomAuthenticationManager authenticationManager;

    @Override
    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

                try {
                    User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
                    Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),
                            user.getPassWord());
                    return authenticationManager.authenticate(authentication);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
                String token = JWT.create()
                .withSubject(authResult.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));

                response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
       response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
       response.getWriter().write(failed.getMessage());
       response.getWriter().flush();
    }
    
}
