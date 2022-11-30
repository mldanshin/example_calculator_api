package com.danshin.calculatorLaw.models.police.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "police_salary_special_conditions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecialConditions {
    @Id
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(nullable = false)
    private String nameShort;

    @Column(nullable = false)
    private short percentMin;

    @Column(nullable = false)
    private short percentMax;

    @Column(nullable = false)
    private LocalDate dateStart;

    @Column
    private LocalDate dateEnd;
}
