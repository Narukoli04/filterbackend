package com.charitydraw.charitydrawbackend.service;

import com.charitydraw.charitydrawbackend.entity.Score;
import com.charitydraw.charitydrawbackend.repository.ScoreRepository;
import com.charitydraw.charitydrawbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public Score addScore(Score score) {
        List<Score> scores = scoreRepository.findByUserEmail(score.getUserEmail());
        if(scores.size()>=5){

            scoreRepository.delete(scores.get(0));
        }
        return scoreRepository.save(score);
    }
    public List<Score> getScores(String email) {
        return scoreRepository.findByUserEmail(email);
    }
    public void deleteScore(Long id,String email) {
        scoreRepository.deleteById(id);
    }
}
