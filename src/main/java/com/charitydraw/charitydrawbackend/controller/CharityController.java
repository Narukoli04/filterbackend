package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.entity.Charity;
import com.charitydraw.charitydrawbackend.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charities")
@CrossOrigin("*")
public class CharityController {

    @Autowired
    private CharityService charityService;

    @GetMapping
    public List<Charity> getAll() {
        return charityService.getAll();
    }

    @PostMapping
    public Charity create(@RequestBody Charity charity) {
        return charityService.create(charity);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        charityService.delete(id);
        return "Deleted";
    }
}