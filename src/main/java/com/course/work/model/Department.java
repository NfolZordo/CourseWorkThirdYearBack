package com.course.work.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "town", nullable = false, length = Integer.MAX_VALUE)
    private String town;

    @Column(name = "address", nullable = false, length = Integer.MAX_VALUE)
    private String address;

}