package com.example.labwk8.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "divisions")
public class Division {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String district;


    @OneToOne(fetch = FetchType.EAGER)
    private Member president;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "division_id")
    private List<Member> members = new ArrayList<>();


    public Division(String name, String district) {
        this.name = name;
        this.district = district;
    }
}