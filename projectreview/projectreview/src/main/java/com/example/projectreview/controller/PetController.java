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

    @PostMapping("/postpetdetails")
    public ResponseEntity<Pet> add(@RequestBody Pet p)
    {
        Pet newuser = ps.create(p);
        return new ResponseEntity<>(newuser,HttpStatus.CREATED);
    }
    
    @GetMapping("/getpetdetails")
    public ResponseEntity <List<Pet>> show()
    {
        List<Pet>obj = ps.getAlldetails();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @GetMapping("/api/pet/{offset}/{pagesize}/{field}")
    public List<Pet> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ps.getsort(offset,pagesize,field);
    }

    @PutMapping("/api/pet/{petId}")
    public ResponseEntity<Pet> putMethodName(@PathVariable("petId") int id, @RequestBody Pet employee) {
        if(ps.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/pet/petBreed/{petBreed}")
    public ResponseEntity<?>getPetByBreed(@PathVariable("petBreed") String petBreed)
    {
            return new ResponseEntity<>(ps.getPetByBreed(petBreed),HttpStatus.OK);
    }

    @DeleteMapping("/api/donor/{donorId}")
    public ResponseEntity<Boolean> delete(@PathVariable("donorId") int id)
    {
        if(ps.deletePet(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
