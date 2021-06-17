package com.company.hrms.dataaccess.abstracts;

import com.company.hrms.entities.concretes.JobSeekers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeekers, Integer> {

    Optional<JobSeekers> findById(int id);

    JobSeekers findByEmail(String email);

    List<JobSeekers> findByEmailContains(String title);

    JobSeekers findByIdentification(String identification);

    JobSeekers findByFirstNameIgnoreCase(String firstName);

    JobSeekers findByLastNameIgnoreCase(String lastName);

}
