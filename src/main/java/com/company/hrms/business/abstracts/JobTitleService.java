package com.company.hrms.business.abstracts;

import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.core.utilities.results.Result;
import com.company.hrms.entities.concretes.JobTitle;

import java.awt.print.Pageable;
import java.util.List;

public interface JobTitleService {
    List<JobTitle> getAll();

    DataResult<List<JobTitle>> getAllPaginated(int pageNo, int pageSize);

    DataResult<List<JobTitle>> getAllSorted();

    DataResult<JobTitle> getById(int id);

    DataResult<JobTitle> getByJobDescription(String jobDescription);

    DataResult<List<JobTitle>> findJobTitlesByJobDescriptionContains(String jobDescription);

    DataResult<List<JobTitle>> findJobTitlesByJobDescriptionStartsWith(String jobDescription);

    DataResult<List<JobTitle>> findJobTitlesByJobDescriptionEndsWith(String jobDescription);

    Result add(JobTitle title);
}