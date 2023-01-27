package com.grineva.springBoot.testProject.service;

import com.grineva.springBoot.testProject.dao.AttempsRepository;
import com.grineva.springBoot.testProject.dao.UserRepository;
import com.grineva.springBoot.testProject.entity.Attemps;
import com.grineva.springBoot.testProject.entity.Role;
import com.grineva.springBoot.testProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class AttempsService {
    @Autowired
    private AttempsRepository attempsRepository;
    @Autowired
    private UserRepository userRepository;

    private static final int MAX_ATTEMPTS = 3;

    public Attemps getAttemp(String username){
        return attempsRepository.findByUsername(username);
    }
    public void updateFailAttemps(String username){
        Attemps attemps=getAttemp(username);

    }
    public void addAttemp(String username) {
        Attemps attemps = attempsRepository.findByUsername(username);
        if (attemps == null) {
            attempsRepository.save(attemps);
            attemps.setAttemp(1);
            attemps.setLastAttemp(new Date());
        } else {

            attemps.setAttemp(attemps.getAttemp() + 1);
            attemps.setLastAttemp(new Date());
        }
    }
    }
