package com.project.beertaster.Controllers;

import com.project.beertaster.Entities.BeerSort;
import com.project.beertaster.Services.BeerSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerSortController {

    @Autowired
    BeerSortService beerSortService;

    @GetMapping("/api/beersorts")
    public List<BeerSort> getAllBeerSorts(){
        return beerSortService.getAllBeerSorts();
    }

    @PostMapping("/api/beersorts")
    public BeerSort addNewBeerSort(@RequestBody BeerSort beerSort){
        return beerSortService.addNewBeerSort(beerSort);
    }

    @PutMapping("/api/beersorts/{id}")
    public BeerSort updateBeerSort(@PathVariable int id, @RequestBody BeerSort beerSort){
        return beerSortService.updateBeerSort(id, beerSort);
    }

    @DeleteMapping("/api/beersorts/{id}")
    public void deleteBeerSort(@PathVariable int id){
        beerSortService.deleteBeerSort(id);
    }
}
