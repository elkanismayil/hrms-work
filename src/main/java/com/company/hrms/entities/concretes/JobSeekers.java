package com.company.hrms.entities.concretes;

import com.company.hrms.core.config.annotations.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "job_seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = "id")
public class JobSeekers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is mandatory")
    @UniqueElements(message = "First name is unique that is why cannot be repeated")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is mandatory")
    @UniqueElements(message = "Last name is unique that is why cannot be repeated")
    private String lastName;

    @Column(name = "identification")
    @NotBlank(message = "Identification is mandatory")
    @UniqueElements(message = "Cannot be repeated")
    @Size(max = 11)
    private String identification;

    @Column(name = "email")
    @NotNull(message = "Email may not be null")
    @Email
    @Size(message = "Email must be contains until 30 characters")
    private String email;

    @Column(name = "password")
    @NotNull
    @NotBlank(message = "New password is mandatory")
    @ValidPassword
    @Size(min = 8, max = 16)
    private String password;

    @Column(name = "password_confirm")
    @NotNull
    @NotBlank(message = "Confirm Password is mandatory")
    @ValidPassword
    @Size(min = 8, max = 16)
    private String passwordConfirm;

    @Column(name = "active")
    private Boolean isActive;
}
