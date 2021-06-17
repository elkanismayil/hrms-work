package com.company.hrms.business.concretes;

import com.company.hrms.business.abstracts.JobSeekerService;
import com.company.hrms.dataaccess.abstracts.JobSeekerDao;
import com.company.hrms.entities.concretes.JobSeekers;
import com.company.hrms.exceptions.JobSeekerNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    @Autowired
    private JobSeekerDao jobSeekerDao;

    @Override
    public JobSeekers findById(int id) {
        return jobSeekerDao.findById(id).orElseThrow(() -> new JobSeekerNotFound("Not found for given id : " + id));
    }

    @Override
    public List<JobSeekers> findAll() {
        return jobSeekerDao.findAll();
    }

    @Override
    public JobSeekers findByEmail(String email) {
        return this.jobSeekerDao.findByEmail(email);
    }

    @Override
    public List<JobSeekers> findByEmailContains(String title) {
        return this.jobSeekerDao.findByEmailContains(title);
    }

    @Override
    public JobSeekers findByIdentification(String identification) {
        return this.jobSeekerDao.findByIdentification(identification);
    }

    @Override
    public JobSeekers findByFirstNameIgnoreCase(String firstName) {
        return jobSeekerDao.findByFirstNameIgnoreCase(firstName);
    }

    @Override
    public JobSeekers findByLastNameIgnoreCase(String lastName) {
        return jobSeekerDao.findByLastNameIgnoreCase(lastName);
    }
}
