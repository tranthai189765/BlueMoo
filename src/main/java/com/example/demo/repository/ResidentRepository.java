package com.example.demo.repository;

import com.example.demo.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Resident findByFullName(String fullName);
    boolean existsByFullName(String fullName);
}