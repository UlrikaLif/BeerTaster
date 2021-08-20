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

    // Access grades by active user - currently a user can only see his/her own grades

    @GetMapping("/api/{userid}/grades")
    public List<Grade> getAllGradesForUser(@PathVariable int userid){
        return gradeService.getAllGradesForUser(userid);
    }

    @PostMapping("/api/{userid}/{beerid}/grades")
    public Grade addNewGrade(@PathVariable int userid, @PathVariable int beerid, @RequestBody Grade grade){
        return gradeService.addNewGradeForUser(userid, beerid, grade);
    }


    @PutMapping("/api/{userid}/{beerid}/grades/{id}")
    public Grade updateGrade(@PathVariable int userid, @PathVariable int beerid, @PathVariable int id, @RequestBody Grade grade){
        return gradeService.updateGrade(userid, beerid, id, grade);
    }


    @DeleteMapping("/api/{userid}/{beerid}/grades/{id}")
    public void deleteGrade(@PathVariable int userid, @PathVariable int beerid, @PathVariable int id){
        gradeService.deleteGrade(userid, beerid, id);
    }

}
