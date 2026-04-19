package com.charitydraw.charitydrawbackend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "draw")
public class Draw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numbers")
    private String numbers;

    @Column(name = "date")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}