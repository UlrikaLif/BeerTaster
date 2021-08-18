package com.project.beertaster.Repositories;

import com.project.beertaster.Entities.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository <Grade, Integer> {
}
