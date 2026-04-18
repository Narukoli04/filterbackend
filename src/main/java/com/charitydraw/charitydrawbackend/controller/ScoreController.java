package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.entity.Score;
import com.charitydraw.charitydrawbackend.security.JwtUtil;
import com.charitydraw.charitydrawbackend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin("*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public Score addScore(@RequestBody Score score,
                          @RequestHeader("Authorization")String token)
    {
        String email = token.substring(7);
        String userEmail=jwtUtil.extractEmail(email);
        score.setUserEmail(userEmail);
        return scoreService.addScore(score);
    }

    @GetMapping
    public List<Score> getMyScores(
            @RequestHeader("Authorization") String token
    ) {
        String jwt = token.substring(7);
        String email = jwtUtil.extractEmail(jwt);

        return scoreService.getScores(email);
    }

    @DeleteMapping("/{id}")
    public String deleteScore(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token
    ) {
        String jwt = token.substring(7);
        String email = jwtUtil.extractEmail(jwt);

        scoreService.deleteScore(id, email);

        return "Score deleted";
    }
}