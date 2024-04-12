
package com.example.projectreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projectreview.model.Pet;
import com.example.projectreview.repository.PetRepo;

@Service
public class PetService {
    
    @Autowired
    PetRepo pr;
    
    public Pet create(Pet pd)
    {
        return pr.save(pd);
    }

    public List <Pet> getAlldetails()
    {
        return pr.findAll();
    }
    public Pet getPetById(int id)
    {
        return pr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id,Pet u)
        {
            if(this.getPetById(id)==null)
            {
                return false;
            }
            try{
                pr.save(u);
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
         public List<Pet> getsort(int pageNumber,int pageSize,String field)
    {          
        return pr.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
    public List<Pet> getPetByBreed(String petBreed)
    {
        return pr.findByPetBreed(petBreed);
    }

    }
