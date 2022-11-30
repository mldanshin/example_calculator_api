package com.danshin.calculatorLaw.models.police;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "police_post_increase")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostIncrease {
    @Id
    private int id;

    @Column(nullable = false)
    private float percent;

    @Column(name = "date", nullable = false)
    private Date date;
}
