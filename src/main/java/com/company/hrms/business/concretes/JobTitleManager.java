package com.company.hrms.business.concretes;

import com.company.hrms.business.abstracts.JobTitleService;
import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.core.utilities.results.Result;
import com.company.hrms.core.utilities.results.SuccessDataResult;
import com.company.hrms.dataaccess.abstracts.JobTitleDao;
import com.company.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    }

    @Override
    public DataResult<List<JobTitle>> getAllPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<>(this.jobTitleDao.findAll(pageable).getContent(),"Success!");
    }

    @Override
    public DataResult<List<JobTitle>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return new SuccessDataResult<>(this.jobTitleDao.findAll(sort),"Successfully sorted");
    }

    @Override
    public DataResult<JobTitle> getById(int id) {
        return new SuccessDataResult<>(this.jobTitleDao.getById(id), "Job title found given id : " + id);
    }

    @Override
    public DataResult<JobTitle> getByJobDescription(String jobDescription) {
        return new SuccessDataResult<>(this.jobTitleDao.findJobTitleByJobDescription(jobDescription), true, "Success");
    }

    @Override
    public DataResult<List<JobTitle>> findJobTitlesByJobDescriptionContains(String jobDescription) {
        return new SuccessDataResult<>(this.jobTitleDao.findJobTitlesByJobDescriptionContains(jobDescription), "Data listed");
    }

    @Override
    public DataResult<List<JobTitle>> findJobTitlesByJobDescriptionStartsWith(String jobDescription) {
        return new SuccessDataResult<>(this.jobTitleDao.findJobTitlesByJobDescriptionStartsWith(jobDescription), true);
    }

    @Override
    public DataResult<List<JobTitle>> findJobTitlesByJobDescriptionEndsWith(String jobDescription) {
        return new SuccessDataResult<>(this.jobTitleDao.findJobTitlesByJobDescriptionEndsWith(jobDescription), "Found");
    }

    @Override
    public List<JobTitle> findByStatusTrue() {
        return this.jobTitleDao.findByStatusTrue();
    }


    @Override
    public Result add(JobTitle title) {
        this.jobTitleDao.save(title);
        return new SuccessDataResult("Job title added successfully");
    }

    @Override
    public DataResult<JobTitle> updateFieldById(String jobDescription, int id) {
        JobTitle jobTitleToUpdate = jobTitleDao.getById(id);
        jobTitleToUpdate.setJobDescription(jobDescription);
        jobTitleDao.save(jobTitleToUpdate);
        return new SuccessDataResult<>("Successfully updated");
    }

    @Override
    public Optional<Integer> deleteById(int id) {
        return this.jobTitleDao.deleteById(id);
    }

}
