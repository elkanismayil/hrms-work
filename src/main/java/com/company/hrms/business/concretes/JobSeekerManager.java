package com.company.hrms.business.concretes;

import com.company.hrms.business.abstracts.JobSeekerService;
import com.company.hrms.core.utilities.results.DataResult;
import com.company.hrms.core.utilities.results.SuccessDataResult;
import com.company.hrms.dataaccess.abstracts.JobSeekerDao;
import com.company.hrms.entities.concretes.JobSeekers;
import com.company.hrms.exceptions.JobSeekerNotFound;
import com.company.hrms.exceptions.PasswordNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobSeekerManager implements JobSeekerService {

    @Autowired
    private JobSeekerDao jobSeekerDao;

    @Override
    public JobSeekers add(JobSeekers seekers) {
        if (!seekers.getPassword().equals(seekers.getPasswordConfirm())){
            throw new PasswordNotMatchException("Please make sure your passwords match");
        }
        return this.jobSeekerDao.save(seekers);
    }

    @Override
    public DataResult<JobSeekers> findByIdAndUpdate(String firstName, String lastName, String email, String identification, String password, String passwordConfirm, int id) {
        this.jobSeekerDao.findByIdAndUpdate(firstName, lastName, email, identification, password, passwordConfirm, id);
        return new SuccessDataResult<>("Successfully updated");
    }

//    @Override
//    public JobSeekers update(JobSeekers seekers, Integer id) {
//        Optional<JobSeekers> updateById = jobSeekerDao.findById(id);
//        JobSeekers newJobSeeker = new JobSeekers();
//        newJobSeeker.setFirstName(seekers.getFirstName());
//        newJobSeeker.setLastName(seekers.getLastName());
//        newJobSeeker.setEmail(seekers.getEmail());
//        newJobSeeker.setIdentification(seekers.getIdentification());
//        newJobSeeker.setPassword(seekers.getPassword());
//        newJobSeeker.setPasswordConfirm(seekers.getPasswordConfirm());
//
//        return this.jobSeekerDao.save(newJobSeeker);
//    }

    @Override
    public JobSeekers findById(int id) {
        return jobSeekerDao.findById(id).orElseThrow(() -> new JobSeekerNotFound("Not job seeker was found for the given id : " + id));
    }

    @Override
    public List<JobSeekers> findAll() {
        return jobSeekerDao.findAll();
    }

    @Override
    public List<JobSeekers> findAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"firstName");
        return this.jobSeekerDao.findAll(sort);
    }

    @Override
    public List<JobSeekers> findAllPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.jobSeekerDao.findAll(pageable).getContent();
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

    @Override
    public DataResult<JobSeekers> deleteById(Integer id) {
        if (id==null){
            throw new JobSeekerNotFound("Id is missing");
        }
        this.jobSeekerDao.deleteById(id);
        return new SuccessDataResult<>("Successfully deleted");
    }
}
