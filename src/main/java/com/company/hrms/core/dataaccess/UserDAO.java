package com.company.hrms.core.dataaccess;

import com.company.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

}
