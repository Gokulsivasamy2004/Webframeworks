
package com.example.projectreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectreview.model.Pet;
import com.example.projectreview.repository.PetRepo;

@Service
public class PetService {
    
    @Autowired
    PetRepo pr;
    
    public Pet create(Pet pu)
    {
        return pr.save(pu);
    }

    public List <Pet> getAlldetails()
    {
        return pr.findAll();
    }
    public Pet getPetById(int id)
    {
        return pr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id,Pet p)
        {
            if(this.getPetById(id)==null)
            {
                return false;
            }
            try{
                pr.save(p);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }

        public boolean deletePet(int id)
        {
            if(this.getPetById(id) == null)
            {
                return false;
            }
            pr.deleteById(id);
            return true;
        }
    }

