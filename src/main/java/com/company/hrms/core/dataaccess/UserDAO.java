package com.company.hrms.core.dataaccess;

import com.company.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    List<User> findAll();
}
