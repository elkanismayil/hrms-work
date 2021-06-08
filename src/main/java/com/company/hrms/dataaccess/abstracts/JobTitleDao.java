package com.company.hrms.dataaccess.abstracts;

import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
    JobTitle getById(int id);

    JobTitle findJobTitleByJobDescription(String jobDescription);

    List<JobTitle> findJobTitlesByJobDescriptionContains(String jobDescription);

    List<JobTitle> findJobTitlesByJobDescriptionStartsWith(String jobDescription);

    List<JobTitle> findJobTitlesByJobDescriptionEndsWith(String jobDescription);

    @Query(value = "INSERT INTO JobTitle (jobDescription) VALUES (:jobDescription)", nativeQuery = true)
    JobTitle insertIntoDb(String jobDescription);

//    @Modifying
//    @Query(value = "UPDATE JobTitle j SET j.jobDescription=:jobDescription WHERE EXISTS j.id = ?", nativeQuery = true)
//    DataResult<JobTitle> updateFieldById(@Param("jobDescription") String jobDescription);
}
