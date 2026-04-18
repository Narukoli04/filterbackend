package com.charitydraw.charitydrawbackend.repository;

import com.charitydraw.charitydrawbackend.entity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharityRepository extends JpaRepository<Charity, Long> {
}