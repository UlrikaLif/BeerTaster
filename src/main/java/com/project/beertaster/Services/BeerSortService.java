package com.project.beertaster.Services;

import com.project.beertaster.Entities.BeerSort;
import com.project.beertaster.Repositories.BeerSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerSortService {

    @Autowired
    BeerSortRepository beerSortRepository;

    public List<BeerSort> getAllBeerSorts() {
        return (List<BeerSort>) beerSortRepository.findAll();
    }
}
