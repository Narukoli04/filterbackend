package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.entity.Draw;
import com.charitydraw.charitydrawbackend.repository.DrawRepository;
import com.charitydraw.charitydrawbackend.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/draw")
public class DrawController {

    @Autowired
    private DrawService drawService;
    @Autowired
    private DrawRepository drawRepository;

    @PostMapping("/run")
    public Draw runDraw() {
        return drawService.runDraw();
    }

    @GetMapping("/history")
    public List<Draw> getHistory() {
        return drawRepository.findAll();
    }
}