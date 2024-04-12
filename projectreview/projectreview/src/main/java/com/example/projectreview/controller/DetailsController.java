package com.example.projectreview.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectreview.model.Details;
import com.example.projectreview.model.Pet;
import com.example.projectreview.service.DetailsService;
import com.example.projectreview.service.PetService;

@RestController
public class DetailsController {
    @Autowired
    DetailsService des;

    @Autowired
    private PetService ps;

    @PostMapping("/details/pet/{petid}")
    public ResponseEntity<Details> add(@RequestBody Details d,@PathVariable("petid") int id)
    {
        Pet newd = ps.getPetById(id); 
        d.setPet(newd);
        return new ResponseEntity<>(des.create(d),HttpStatus.CREATED);
    } 
}

