package com.example.projectreview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectreview.model.Details;
import com.example.projectreview.repository.DetailsRepo;

@Service
public class DetailsService {
    @Autowired
    DetailsRepo der;

    public Details create(Details d)
    {
        return der.save(d);
    }
}
