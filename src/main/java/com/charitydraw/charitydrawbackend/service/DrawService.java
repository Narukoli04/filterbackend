package com.charitydraw.charitydrawbackend.service;

import com.charitydraw.charitydrawbackend.entity.Draw;
import com.charitydraw.charitydrawbackend.repository.DrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class DrawService {

    @Autowired
    private DrawRepository drawRepository;

    public Draw runDraw() {

        Random r = new Random();

        String numbers = (r.nextInt(45) + 1) + "," +
                (r.nextInt(45) + 1) + "," +
                (r.nextInt(45) + 1) + "," +
                (r.nextInt(45) + 1) + "," +
                (r.nextInt(45) + 1);

        System.out.println("Generated Numbers: " + numbers); // 🔥 DEBUG

        Draw draw = new Draw();
        draw.setNumbers(numbers);  // 🔥 MUST SET
        draw.setDate(LocalDate.now());

        Draw saved = drawRepository.save(draw);

        System.out.println("Saved Draw: " + saved.getNumbers()); // 🔥 DEBUG

        return saved;
    }

    public List<Draw> getHistory() {
        return drawRepository.findAll();
    }
}