package com.company.hrms.business.abstracts;

import com.company.hrms.core.entities.User;
import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<List<User>> findAllUsers();
}
