package com.company.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"salary_id", "min", "max"})
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Integer id;

    @Column(name = "min")
    private BigDecimal min;

    @Column(name = "max")
    private BigDecimal max;

    @OneToOne(mappedBy = "salary")
    private Employers employers;
}
