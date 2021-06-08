package com.company.hrms.entities.concretes;

import com.company.hrms.core.config.annotations.CustomAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_title")
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "job_desc", unique = true)
    @UniqueElements(message = "This field cannot be repeated")
    @NotBlank(message = "Job title is mandatory")
    private String jobDescription;
}
