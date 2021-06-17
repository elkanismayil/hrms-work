package com.company.hrms.exceptions;

import javax.persistence.EntityNotFoundException;

public class JobSeekerNotFound extends EntityNotFoundException {
    public JobSeekerNotFound(String msg) {
        super(msg);
    }
}
