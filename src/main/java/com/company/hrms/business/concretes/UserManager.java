package com.company.hrms.business.concretes;

import com.company.hrms.business.abstracts.UserService;
import com.company.hrms.core.dataaccess.UserDAO;
import com.company.hrms.core.entities.User;
import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.core.utilities.results.Result;
import com.company.hrms.core.utilities.results.SuccessDataResult;
import com.company.hrms.core.utilities.results.SuccessResult;
import com.company.hrms.exceptions.PasswordNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Result add(User user) {
        if (!user.getPassword().equals(user.getConfirmPassword())){
            throw new PasswordNotMatchException("Please make sure your passwords match");
        }
        userDAO.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public DataResult<List<User>> findAllUsers() {
        return new SuccessDataResult<>(this.userDAO.findAll(),"All users listed");
    }
}
