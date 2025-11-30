package com.example.labwk8.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "guests")
public class Guest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    @Enumerated(EnumType.STRING)
    private GuestStatus status;


    public Guest(String name, GuestStatus status) {
        this.name = name;
        this.status = status;
    }
}