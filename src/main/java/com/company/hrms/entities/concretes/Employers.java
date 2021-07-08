package com.company.hrms.entities.concretes;

import com.company.hrms.entities.abstracts.StatusModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employers extends StatusModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_repeat", nullable = false)
    private String confirmPassword;

    @Column(name = "job_title_id", nullable = false)
    private Integer jobId;

    @OneToMany(mappedBy = "employers")
    private List<Regions> regions = new ArrayList<>();

}
