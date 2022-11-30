package com.danshin.calculatorLaw.models.police;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "police_rank")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rank {
    @Id
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false)
    private LocalDate dateStart;

    @Column
    private LocalDate dateEnd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_type_id")
    private PostType postType;
}
