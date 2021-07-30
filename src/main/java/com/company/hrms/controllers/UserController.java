package com.company.hrms.controllers;

import com.company.hrms.business.abstracts.UserService;
import com.company.hrms.core.entities.User;
import com.company.hrms.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public DataResult<List<User>> findAll(){
        return service.findAllUsers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@Valid @RequestBody User user){

        return ResponseEntity.ok(service.add(user));
    }
}
