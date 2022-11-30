package com.danshin.calculatorLaw.models;

import com.danshin.calculatorLaw.models.police.salary.LawPS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "law")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Law {
    @Id
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private LawType lawType;

    @Column(nullable = false)
    private short number;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateStart;

    @Column(nullable = true)
    private LocalDate dateEnd;

    @OneToOne(optional = false, mappedBy = "law")
    private LawPS lawPoliceSalary;
}
