package com.project.beertaster.Repositories;

import com.project.beertaster.Entities.BeerSort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerSortRepository extends CrudRepository <BeerSort, Integer> {





}
