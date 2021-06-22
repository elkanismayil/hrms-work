package com.company.hrms.business.abstracts;

import com.company.hrms.core.entities.User;
import com.company.hrms.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<User>> findAllUsers();
}
