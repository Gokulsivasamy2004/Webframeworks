package com.example.projectreview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    private int petId;
    private String petType;
    private int petPrice;
    public int getPetId() {
        return petId;
    }
    public void setPetId(int petId) {
        this.petId = petId;
    }
    public String getPetType() {
        return petType;
    }
    public void setPetType(String petType) {
        this.petType = petType;
    }
    public int getPetPrice() {
        return petPrice;
    }
    public void setPetPrice(int petPrice) {
        this.petPrice = petPrice;
    }
    public Pet(int petId, String petType, int petPrice) {
        this.petId = petId;
        this.petType = petType;
        this.petPrice = petPrice;
    }
    public Pet() {
    }
    
}
