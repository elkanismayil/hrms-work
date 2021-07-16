package com.company.hrms.entities.concretes;

import com.company.hrms.entities.abstracts.AuditModel;
import com.company.hrms.utils.MathUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_title")
public class JobTitle extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "job_desc", unique = true)
    @UniqueElements(message = "This field cannot be repeated")
    @NotBlank(message = "Job title is mandatory")
    private String jobDescription;

    @Column(name = "is_active")
    private boolean status = false;

    @Column(name = "open_position", nullable = false, insertable = false, updatable = false)
    @Generated(value = GenerationTime.ALWAYS)
    @JsonIgnore
    private Integer openPosition = MathUtil.findRandom();

    @Column(name = "deadline")
    @Temporal(value = TemporalType.DATE)
    private Date deadline;

}
