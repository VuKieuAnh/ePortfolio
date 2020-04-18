package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String coachId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    private String phoneNumber;

    private String address;

    private String notice;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "coaches_roles",
            joinColumns = {@JoinColumn(name = "coaches_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;
}
