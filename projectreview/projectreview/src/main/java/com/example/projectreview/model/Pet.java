package com.example.projectreview.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "pet",cascade = CascadeType.ALL)
    // @JoinColumn(name = "details_id")
    @JsonManagedReference
    private Details details;
    private String petName;
    private String petArea;
    private String petBreed;
    private String petAge;
    private String petProof;
    private String license;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getPetArea() {
        return petArea;
    }
    public void setPetArea(String petArea) {
        this.petArea = petArea;
    }
    
    public String getPetBreed() {
        return petBreed;
    }
    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
    public String getPetAge() {
        return petAge;
    }
    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }
    public String getPetProof() {
        return petProof;
    }
    public void setPetProof(String petProof) {
        this.petProof = petProof;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    
    public Details getDetails() {
        return details;
    }
    public void setDetails(Details details) {
        this.details = details;
    }
    
    public Pet() {
    }
    public Pet(int id, String petName, String petArea,String petBreed, String petAge,
            String petProof, String license,Details details) {
        this.id = id;
        this.petName = petName;
        this.petArea = petArea;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petProof = petProof;
        this.license = license;
        this.details = details;
    }    
}
