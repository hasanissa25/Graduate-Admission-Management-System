package GAMS.controllers;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.Crudrepository.FieldOfResearchRepo;
import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    EndUserRepo userRepository;

    @Autowired
    FieldOfResearchRepo researchRepository;

    @Autowired
    StudentRepo studentRepo;


    @GetMapping("/studentProfile")
    public String studentProfile(Model model, HttpServletRequest request) {

        model.addAttribute("student", new Student());
        model.addAttribute("view", "studentProfile");
        return "layout";
    }

    @PostMapping("/studentProfile")
    public String saveProfile(@ModelAttribute Student formStudent, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        EndUser endUser = userRepository.findByUsername(auth.getName());
        Student student = studentRepo.findByUsername(auth.getName());

        if(endUser == null){
            // This is an error because the student is supposed to exist in DB
            model.addAttribute("view", "index");
            return "layout";
        }
        else if(student == null) {
            formStudent.setUsername(endUser.getUsername());
            formStudent.setPassword(endUser.getPassword());
            formStudent.setConfPassword(endUser.getConfPassword());
            formStudent.setHasProfile(true);
            userRepository.delete(endUser);
            userRepository.save(formStudent);
        } else {
            student.setEmail(formStudent.getEmail());
            student.setCv(formStudent.getCv());
            student.setDiploma(formStudent.getDiploma());
            student.setGradeAudit(formStudent.getGradeAudit());
            student.setHasProfile(true);
            userRepository.save(student);
        }

        model.addAttribute("view", "index");
        return "redirect:";

    }

    @GetMapping("/studentInfo")
    public String studentInfo(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student st;
        try {
            st = (Student) userRepository.findByUsername(auth.getName());
        } catch (Exception ex) {
            st = new Student();
        }

        Iterable<FieldOfResearch> all = researchRepository.findAll();
        List<FieldOfResearch> active = new ArrayList<>();
        for(FieldOfResearch research : all){
            if(research.hasStudent(auth.getName())){
                active.add(research);
            }
        }

        model.addAttribute("student", st);
        model.addAttribute("selectedFOR", active);
        model.addAttribute("view", "studentInfo");
        return "layout";

    }

}