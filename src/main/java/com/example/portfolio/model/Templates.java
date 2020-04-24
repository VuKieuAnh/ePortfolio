package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "templates")
public class Templates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Programs programs;
}
