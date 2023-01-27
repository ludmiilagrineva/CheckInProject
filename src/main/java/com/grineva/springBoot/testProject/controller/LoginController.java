package com.grineva.springBoot.testProject.controller;

import com.grineva.springBoot.testProject.dao.UserRepository;
import com.grineva.springBoot.testProject.entity.Attemps;
import com.grineva.springBoot.testProject.entity.User;

import com.grineva.springBoot.testProject.service.AttempsService;
import com.grineva.springBoot.testProject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AttempsService attempsService;

    @GetMapping("/login")
    public String authenticate(Authentication authentication) throws AuthenticationException {
        User user = userRepository.findByUsername(authentication.getName());
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        else if (!user.getPassword().equals(authentication.getCredentials().toString())) {

            attempsService.addAttemp(authentication.getName());
            throw new BadCredentialsException("Пароли не совпадают");
        }

        return "login";


    }
}
