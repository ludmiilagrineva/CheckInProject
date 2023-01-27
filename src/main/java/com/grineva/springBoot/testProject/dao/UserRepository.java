package com.grineva.springBoot.testProject.dao;



import com.grineva.springBoot.testProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
public User findByUsername(String username);
}
