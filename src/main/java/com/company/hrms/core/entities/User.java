package com.company.hrms.core.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users")
@EqualsAndHashCode
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    @Email
    @NotBlank(message = "Email is mandatory")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotBlank
    @NotNull
    private String password;

    @Column(name = "confirm_password")
    @NotBlank
    @NotNull
    private String confirmPassword;

    public User() {
    }

    public User(int id, String email, String password, String confirmPassword) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
