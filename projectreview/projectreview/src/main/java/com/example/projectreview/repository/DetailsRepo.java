package com.example.projectreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectreview.model.Details;

public interface DetailsRepo extends JpaRepository<Details, Integer>{
    
}
