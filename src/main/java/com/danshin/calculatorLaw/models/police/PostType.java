package com.danshin.calculatorLaw.models.police;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "police_post_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostType {
    @Id
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private LocalDate dateStart;

    @Column
    private LocalDate dateEnd;

    @OneToMany(mappedBy = "postType")
    private List<Post> posts;

    @OneToMany(mappedBy = "postType")
    private List<Rank> ranks;
}
