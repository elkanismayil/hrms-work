package com.company.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "job_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class JobHistory implements Serializable {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @CreatedDate
    @Column(name = "start_date", nullable = false, updatable = false)
    private Date startDate;

    @LastModifiedDate
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "department_id", nullable = false)
    private Integer departmentId;
}
