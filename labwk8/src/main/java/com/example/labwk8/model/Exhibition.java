package com.example.labwk8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "exhibitions")
public class Exhibition extends Event {
    public Exhibition(String title, java.time.LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }
}