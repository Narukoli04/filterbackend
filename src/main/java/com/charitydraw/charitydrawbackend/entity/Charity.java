package com.charitydraw.charitydrawbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // getters setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}