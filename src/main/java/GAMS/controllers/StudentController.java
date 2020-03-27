package GAMS.controllers;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.Crudrepository.FieldOfResearchRepo;
import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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

//
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

        if(endUser == null){
            // This is an error because the student is supposed to exist in DB
            model.addAttribute("view", "index");
            return "layout";
        }
        else{
            formStudent.setUsername(endUser.getUsername());
            formStudent.setPassword(endUser.getPassword());
            formStudent.setConfPassword(endUser.getConfPassword());

            userRepository.save(formStudent);
            userRepository.delete(endUser);

            model.addAttribute("view", "index");
            return "redirect:";
        }

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