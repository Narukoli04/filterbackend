package com.charitydraw.charitydrawbackend.service;

import com.charitydraw.charitydrawbackend.entity.Charity;
import com.charitydraw.charitydrawbackend.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityService {

    @Autowired
    private CharityRepository charityRepository;

    public List<Charity> getAll() {
        return charityRepository.findAll();
    }

    public Charity create(Charity charity) {
        return charityRepository.save(charity);
    }

    public void delete(Long id) {
        charityRepository.deleteById(id);
    }
}