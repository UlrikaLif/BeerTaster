package com.project.beertaster.Services;

import com.project.beertaster.Entities.BeerSort;
import com.project.beertaster.Entities.Grade;
import com.project.beertaster.Entities.User;
import com.project.beertaster.Repositories.BeerSortRepository;
import com.project.beertaster.Repositories.GradeRepository;
import com.project.beertaster.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BeerSortRepository beerSortRepository;

    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }


    // Access grades by active user - currently a user can only see his/her own grades

    public List<Grade> getAllGradesForUser(int userid) {
        if (userRepository.existsById(userid)){
            return gradeRepository.findAllByUserId(userid);
        }
        else return null;
    }

    public Grade addNewGradeForUser(int userid, int beerid, Grade grade) {
        // Check that userid and beerid exists
        if ((userRepository.existsById(userid)) && beerSortRepository.existsById(beerid)){
            // Get the user and beerSort with the given ids.
            User user = userRepository.findById(userid).get();
            BeerSort beerSort = beerSortRepository.findById(beerid).get();
            // Assign the user and beerSort to grade
            grade.setUser(user);
            grade.setBeerSort(beerSort);
            // Send grade for placement in database (via gradeRepository) and return grade with id
            return gradeRepository.save(grade);
        }
        else{
            return null;
        }

    }

    public Grade updateGrade(int userid, int beerid, int id, Grade grade) {
        // Check if there exists a grade with given id
        if (gradeRepository.existsById(id)){
            // Collects grade with the given id from database
            Grade gradeFromDB = gradeRepository.findById(id);
            // Check if given userid and beerid matches what is entered in the database
            if ((gradeFromDB.getUser().getId() == userid) && (gradeFromDB.getBeerSort().getId() == beerid)){
                // Check that user and beerSort exists
                if ((userRepository.existsById(userid)) && beerSortRepository.existsById(beerid)) {
                    // Get user and beerSort and assign to new grade
                    User user = gradeFromDB.getUser();
                    BeerSort beerSort = gradeFromDB.getBeerSort();
                    grade.setUser(user);
                    grade.setBeerSort(beerSort);
                    grade.setId(id);
                    return gradeRepository.save(grade);
                }
            }
        }
        return null;
    }

    public void deleteGrade(int userid, int beerid, int id) {
        // Check if given id exists
        if (gradeRepository.existsById(id)){
            // Collects grade with the given id from database
            Grade gradeFromDB = gradeRepository.findById(id);
            // Check if given userid and beerid matches what is entered in the database
            if ((gradeFromDB.getUser().getId() == userid) && (gradeFromDB.getBeerSort().getId() == beerid)){
                // Delete the grade
                gradeRepository.deleteById(id);
            }
        }
    }
}
