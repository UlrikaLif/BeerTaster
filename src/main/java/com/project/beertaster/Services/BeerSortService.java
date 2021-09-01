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

    public BeerSort addNewBeerSort(BeerSort beerSort) {
        return beerSortRepository.save(beerSort);
    }


    public BeerSort updateBeerSort(int id, BeerSort beerSort) {
        if (beerSortRepository.existsById(id)){
            beerSort.setId(id);
            return beerSortRepository.save(beerSort);
        }
        return null;
    }

    public void deleteBeerSort(int id) {
        beerSortRepository.deleteById(id);
    }
}
