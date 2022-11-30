package com.danshin.calculatorLaw.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "law_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LawType {
    @Id
    private int id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private short importance;

    @OneToMany(mappedBy = "lawType")
    private List<Law> laws;
}
