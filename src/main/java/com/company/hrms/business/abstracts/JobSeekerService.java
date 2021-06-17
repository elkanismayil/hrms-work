package com.company.hrms.business.abstracts;

import com.company.hrms.entities.concretes.JobSeekers;

import java.util.List;

public interface JobSeekerService {
    JobSeekers findById(int id);

    List<JobSeekers> findAll();

    JobSeekers findByEmail(String email);

    List<JobSeekers> findByEmailContains(String title);

    JobSeekers findByIdentification(String identification);

    JobSeekers findByFirstNameIgnoreCase(String firstName);

    JobSeekers findByLastNameIgnoreCase(String lastName);
}
