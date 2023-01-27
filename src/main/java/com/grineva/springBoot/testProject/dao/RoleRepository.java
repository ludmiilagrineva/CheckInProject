package com.grineva.springBoot.testProject.dao;



import com.grineva.springBoot.testProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
