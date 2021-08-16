package com.project.beertaster.Controllers;

import com.project.beertaster.Entities.Grade;
import com.project.beertaster.Services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/api/grades")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }


    @PostMapping("/api/grades")
    public void addNewGrade(@RequestBody Grade grade){
        gradeService.addNewGrade(grade);
    }


    @PutMapping("/api/grades/{id}")
    public void updateGrade(@PathVariable int id, @RequestBody Grade grade){
        gradeService.updateGrade(id, grade);
    }


    @DeleteMapping("/api/grades/{id}")
    public void deleteGrade(@PathVariable int id){
        gradeService.deleteGrade(id);
    }

}
