package com.project.beertaster.Services;

import com.project.beertaster.Entities.Grade;
import com.project.beertaster.Repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

    public void addNewGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    public void updateGrade(int id, Grade grade) {
        if (gradeRepository.existsById(id)){
            grade.setId(id);
            gradeRepository.save(grade);
        }
    }

    public void deleteGrade(int id) {
        gradeRepository.deleteById(id);
    }
}
