package com.company.hrms.business.abstracts;

import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.core.utilities.results.Result;
import com.company.hrms.entities.concretes.JobSeekers;

import java.util.List;

public interface JobSeekerService {

    JobSeekers add(JobSeekers seekers);

    DataResult<JobSeekers> findByIdAndUpdate(String firstName, String lastName, String email, String identification, String password, String passwordConfirm, int id);

    JobSeekers findById(int id);

    List<JobSeekers> findAll();

    List<JobSeekers> findAllSorted();

    List<JobSeekers> findAllPaginated(int pageNo, int pageSize);

    JobSeekers findByEmail(String email);

    List<JobSeekers> findByEmailContains(String title);

    JobSeekers findByIdentification(String identification);

    JobSeekers findByFirstNameIgnoreCase(String firstName);

    JobSeekers findByLastNameIgnoreCase(String lastName);
}
