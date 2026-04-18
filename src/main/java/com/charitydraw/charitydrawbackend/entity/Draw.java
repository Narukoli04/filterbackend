package com.charitydraw.charitydrawbackend.entity;

import jakarta.persistence.*;

@Entity
public class Draw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String winnerEmail;
    private int score;
    private String date;

    // getters setters
    public Long getId() { return id; }

    public String getWinnerEmail() { return winnerEmail; }
    public void setWinnerEmail(String winnerEmail) { this.winnerEmail = winnerEmail; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}