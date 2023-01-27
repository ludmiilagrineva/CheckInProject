package com.grineva.springBoot.testProject.dao;

import com.grineva.springBoot.testProject.entity.Attemps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttempsRepository extends JpaRepository<Attemps, Long> {
public Attemps findByUsername(String username);
}
