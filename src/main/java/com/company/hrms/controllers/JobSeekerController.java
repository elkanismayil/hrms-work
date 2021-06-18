package com.company.hrms.controllers;

import com.company.hrms.business.abstracts.JobSeekerService;
import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.entities.concretes.JobSeekers;
import com.company.hrms.exceptions.NotFoundGivenContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobseekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JobSeekers add(@RequestBody JobSeekers seekers) {
        return this.service.add(seekers);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public DataResult<JobSeekers> findByIdAndUpdate(String firstName, String lastName, String email, String identification, String password, String passwordConfirm, @PathVariable(name = "id", required = false) int id){
        return service.findByIdAndUpdate(firstName, lastName, email, identification, password, passwordConfirm, id);
    }

    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    public JobSeekers findById(@RequestParam int id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<JobSeekers> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/get_all_paginated", method = RequestMethod.GET)
    public List<JobSeekers> findAllPaginated(int pageNo, int pageSize) {
        return this.service.findAllPaginated(pageNo, pageSize);
    }

    @RequestMapping(value = "/get_all_sorted", method = RequestMethod.GET)
    public List<JobSeekers> findAllSorted() {
        return this.service.findAllSorted();
    }

    @RequestMapping(value = "/get_by_email", method = RequestMethod.GET)
    public JobSeekers findByEmail(@RequestParam String email) {
        return this.service.findByEmail(email);
    }

    @RequestMapping(value = "/find-by-email-contains", method = RequestMethod.GET)
    public List<JobSeekers> findByEmailContains(@RequestParam String title) {
        return this.service.findByEmailContains(title);
    }

    @RequestMapping(value = "/get_by_identification", method = RequestMethod.GET)
    public JobSeekers findByIdentification(@RequestParam String identification) {
        return this.service.findByIdentification(identification);
    }

    @RequestMapping(value = "/get_by_first_name", method = RequestMethod.GET)
    public JobSeekers findByFirstName(@RequestParam String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new NotFoundGivenContentException("Name not found");
        }
        return this.service.findByFirstNameIgnoreCase(firstName);
    }

    @RequestMapping(value = "/get_by_last_name", method = RequestMethod.GET)
    public JobSeekers findByLastName(@RequestParam String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new NotFoundGivenContentException("Name not found");
        }
        return this.service.findByLastNameIgnoreCase(lastName);
    }

}
