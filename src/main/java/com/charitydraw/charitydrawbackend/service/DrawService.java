package com.charitydraw.charitydrawbackend.service;

import com.charitydraw.charitydrawbackend.entity.Draw;
import com.charitydraw.charitydrawbackend.entity.Score;
import com.charitydraw.charitydrawbackend.repository.DrawRepository;
import com.charitydraw.charitydrawbackend.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DrawService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private DrawRepository drawRepository;

    public List<Score> runDraw() {
        List<Score> winners = scoreRepository.findTop3ByOrderByValueDesc();

        for (Score s : winners) {
            Draw draw = new Draw();
            draw.setWinnerEmail(s.getUserEmail());
            draw.setScore(s.getValue());
            draw.setDate(LocalDate.now().toString());
            drawRepository.save(draw);
        }

        return winners;
    }

    public List<Draw> history() {
        return drawRepository.findAll();
    }
}