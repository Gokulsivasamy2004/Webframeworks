
package com.example.projectreview.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectreview.model.Pet;

public interface PetRepo extends JpaRepository<Pet,Integer>{
    @Query("SELECT d from Pet d WHERE d.petBreed = :petBreed")
    List<Pet>findByPetBreed(@Param("petBreed") String petBreed);
}
