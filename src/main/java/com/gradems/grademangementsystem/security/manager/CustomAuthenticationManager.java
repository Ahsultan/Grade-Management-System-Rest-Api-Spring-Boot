package com.gradems.grademangementsystem.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gradems.grademangementsystem.entity.User;
import com.gradems.grademangementsystem.service.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       User user = userService.getUserByUserName(authentication.getName());
       if(!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassWord())) {
        throw new BadCredentialsException("You Provided an incorrect Password");
       }

       return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassWord());
    }
    
}
