package com.project.beertaster.Controllers;

import com.project.beertaster.Entities.Grade;
import com.project.beertaster.Services.GradeService;
import com.project.beertaster.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    GradeService gradeService;

    @Autowired
    UserService userService;

    // Access grades by active user - currently a user can only see his/her own grades
    // Check that userid matches id for currentUser.

    @GetMapping("/api/{userid}/grades")
    public List<Grade> getAllGradesForUser(@PathVariable int userid){
        if (userid == userService.findCurrentUser().getId()) {
            return gradeService.getAllGradesForUser(userid);
        }
        else{
            return null;
        }
    }

    @PostMapping("/api/{userid}/{beerid}/grades")
    public Grade addNewGrade(@PathVariable int userid, @PathVariable int beerid, @RequestBody Grade grade){
        if (userid == userService.findCurrentUser().getId()) {
            return gradeService.addNewGradeForUser(userid, beerid, grade);
        }
        else{
            return null;
        }
    }


    @PutMapping("/api/{userid}/{beerid}/grades/{id}")
    public Grade updateGrade(@PathVariable int userid, @PathVariable int beerid, @PathVariable int id, @RequestBody Grade grade) {
        if (userid == userService.findCurrentUser().getId()) {
            return gradeService.updateGrade(userid, beerid, id, grade);
        }
        else{
            return null;
        }
    }


    @DeleteMapping("/api/{userid}/{beerid}/grades/{id}")
    public void deleteGrade(@PathVariable int userid, @PathVariable int beerid, @PathVariable int id){
        if (userid == userService.findCurrentUser().getId()) {
            gradeService.deleteGrade(userid, beerid, id);
        }
    }

}
