package com.company.hrms.dataaccess.abstracts;

import com.company.hrms.entities.concretes.JobSeekers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeekers, Integer> {

    Optional<JobSeekers> findById(int id);

    @Modifying
    @Query("UPDATE JobSeekers js SET js.firstName=?1, js.lastName=?2, js.email=?3, js.identification=?4, js.password=?5, js.passwordConfirm=?6 WHERE js.id = ?7")
    void findByIdAndUpdate(String firstName, String lastName, String email, String identification, String password, String passwordConfirm, int id);

    JobSeekers findByEmail(String email);

    List<JobSeekers> findByEmailContains(String title);

    JobSeekers findByIdentification(String identification);

    JobSeekers findByFirstNameIgnoreCase(String firstName);

    JobSeekers findByLastNameIgnoreCase(String lastName);

}
