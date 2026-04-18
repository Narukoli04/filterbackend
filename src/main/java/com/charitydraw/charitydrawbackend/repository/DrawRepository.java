package com.charitydraw.charitydrawbackend.repository;

import com.charitydraw.charitydrawbackend.entity.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Long> {
}