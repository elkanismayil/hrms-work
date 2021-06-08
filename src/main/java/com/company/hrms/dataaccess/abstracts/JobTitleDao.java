package com.company.hrms.dataaccess.abstracts;

import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
    JobTitle getById(int id);

    JobTitle findJobTitleByJobDescription(String jobDescription);

    List<JobTitle> findJobTitlesByJobDescriptionContains(String jobDescription);

    List<JobTitle> findJobTitlesByJobDescriptionStartsWith(String jobDescription);

    List<JobTitle> findJobTitlesByJobDescriptionEndsWith(String jobDescription);

    @Query(value = "INSERT INTO JobTitle (jobDescription) VALUES (:jobDescription)", nativeQuery = true)
    JobTitle insertIntoDb(String jobDescription);


    @Modifying
    @Query("delete from JobTitle j where j.id=:id")
    Optional<Integer> deleteById(@Param("id") int id);
}
