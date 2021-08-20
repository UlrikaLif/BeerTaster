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
    public void addNewBeerSort(@RequestBody BeerSort beerSort){
        beerSortService.addNewBeerSort(beerSort);
    }

    @PutMapping("/api/beersorts/{id}")
    public void updateBeerSort(@PathVariable int id, @RequestBody BeerSort beerSort){
        beerSortService.updateBeerSort(id, beerSort);
    }

    @DeleteMapping("/api/beersorts/{id}")
    public void deleteBeerSort(@PathVariable int id){
        beerSortService.deleteBeerSort(id);
    }
}
