package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.entity.Draw;
import com.charitydraw.charitydrawbackend.entity.Score;
import com.charitydraw.charitydrawbackend.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/draw")
@CrossOrigin("*")
public class DrawController {

    @Autowired
    private DrawService drawService;

    @PostMapping("/run")
    public List<Score> runDraw() {
        return drawService.runDraw();
    }

    @GetMapping("/history")
    public List<Draw> history() {
        return drawService.history();
    }
}