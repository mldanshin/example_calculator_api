package com.danshin.calculatorLaw.models.police.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "police_salary_statistics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Statistics {
    @Id
    private int id;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(nullable = false)
    private String ip;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String request;
}
