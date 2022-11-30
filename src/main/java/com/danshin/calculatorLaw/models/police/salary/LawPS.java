package com.danshin.calculatorLaw.models.police.salary;

import com.danshin.calculatorLaw.models.Law;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "police_salary_law")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LawPS {
    @Id
    private int id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "law_id", referencedColumnName = "id")
    private Law law;
}
