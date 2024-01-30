package com.gradems.grademangementsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.gradems.grademangementsystem.security.filter.ExceptionHandlerFilter;
import com.gradems.grademangementsystem.security.filter.JWTAuthorizationFilter;
import com.gradems.grademangementsystem.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    
    private final CustomAuthenticationManager customAuthenticationManager;
    RequestMatcher matcher = new AntPathRequestMatcher("/authenticate");

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager, null);
        authenticationFilter.setRequestMatcher(matcher);
        
        http
        .csrf(c -> c.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
        .anyRequest().authenticated())
        .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
        .addFilter(authenticationFilter)
        .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
        .sessionManagement( session -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}
