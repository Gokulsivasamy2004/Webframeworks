package com.example.projectreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projectreview.model.Pet;

public interface PetRepo extends JpaRepository<Pet,Integer> {
    
}
