package com.danshin.calculatorLaw.models.police;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "police_post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(nullable = false)
    private String nameShort;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false)
    private LocalDate dateStart;

    @Column
    private LocalDate dateEnd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private PostType postType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "government_id")
    private Government government;
}
