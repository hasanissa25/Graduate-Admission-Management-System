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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;

@Controller
public class CandidatesController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FieldOfResearchRepo fieldOfResearchRepo;


    @GetMapping("/StudentCandidates")
    public String ListOfCandidates(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Iterable<FieldOfResearch> all = fieldOfResearchRepo.findAll();
        Iterable<Student> all2 = studentRepo.findAll();
        List<FieldOfResearch> active = new ArrayList<>();

        for(FieldOfResearch research : all){
            if(research.isActive()){
                active.add(research);
            }
        }
        model.addAttribute("dat", active);

        model.addAttribute("dat2", all2);

        model.addAttribute("view", "StudentCandidates");
        return "layout";

    }



}
