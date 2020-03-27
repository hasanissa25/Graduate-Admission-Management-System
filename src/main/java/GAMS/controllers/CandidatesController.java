package GAMS.controllers;

import GAMS.Crudrepository.FieldOfResearchRepo;
import GAMS.Crudrepository.StudentRepo;
import GAMS.email.EmailService;
import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

public class CandidatesController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FieldOfResearchRepo fieldOfResearchRepo;


    @GetMapping("/StudentCandidates")
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Iterable<Student> all = studentRepo.findAll();

        model.addAttribute("dat", all);

        model.addAttribute("view", "StudentCandidates");
        return "layout";

    }



}
