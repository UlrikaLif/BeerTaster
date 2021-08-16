package com.project.beertaster.Controllers;

import com.project.beertaster.Entities.BeerSort;
import com.project.beertaster.Services.BeerSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeerSortController {

    @Autowired
    BeerSortService beerSortService;

    @GetMapping("/api/beersorts")
    public List<BeerSort> getAllBeerSorts(){
        return beerSortService.getAllBeerSorts();
    }
}
