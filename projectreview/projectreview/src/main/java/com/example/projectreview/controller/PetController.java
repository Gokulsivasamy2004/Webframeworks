

package com.example.projectreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.projectreview.model.Pet;
import com.example.projectreview.service.PetService;

@RestController
public class PetController {
    @Autowired
    PetService ps;

    @PostMapping("/api/pet")
    public ResponseEntity<Pet> add(@RequestBody Pet p)
    {
        Pet newpet = ps.create(p);
        return new ResponseEntity<>(newpet,HttpStatus.CREATED);
    }
    
    @GetMapping("/api/pets")
    public ResponseEntity <List<Pet>> show()
    {
        List<Pet>obj = ps.getAlldetails();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PutMapping("/api/pet/{petId}")
    public ResponseEntity<Pet> putMethodName(@PathVariable("petId") int id, @RequestBody Pet employee) {
        if(ps.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/pet/{petId}")
    public ResponseEntity<Boolean> delete(@PathVariable("petId") int id)
    {
        if(ps.deletePet(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
