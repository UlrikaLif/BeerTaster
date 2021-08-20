package com.project.beertaster.Repositories;

import com.project.beertaster.Entities.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends CrudRepository <Grade, Integer> {

    List<Grade> findAllByUserId(int userid);

    Grade findById(int id);
}
