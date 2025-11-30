package com.example.labwk8.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String company;
    private String title;


    @Embedded
    private Name name;


    public Contact(String company, String title, Name name) {
        this.company = company;
        this.title = title;
        this.name = name;
    }
}