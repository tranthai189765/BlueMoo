package com.example.demo.service;

import com.example.demo.entity.Resident;
import com.example.demo.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {
    @Autowired
    private ResidentRepository residentRepository;

    public Resident findById(Long id) {
        return residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
    }
}
