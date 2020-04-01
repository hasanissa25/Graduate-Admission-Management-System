package GAMS.controllers;
import GAMS.Crudrepository.CandidateRepo;
import GAMS.Crudrepository.EndUserRepo;
import GAMS.Crudrepository.FieldOfResearchRepo;
import GAMS.Crudrepository.StudentRepo;
import GAMS.email.EmailService;
import GAMS.entity.Candidate;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class DisplayFinalDecisionController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EndUserRepo endUserRepo;

    @Autowired
    private FieldOfResearchRepo fieldOfResearchRepo;


    @GetMapping("/Decisions")
    public String createit(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Iterable<FieldOfResearch> all = fieldOfResearchRepo.findAll();
        Iterable<Student> all2 = studentRepo.findAll();
        Iterable<Candidate> all3 = candidateRepo.findAll();
        List<FieldOfResearch> active = new ArrayList<>();

        for(FieldOfResearch research : all){
            if(research.isActive()){
                active.add(research);
            }
        }
        model.addAttribute("dat", active);

        model.addAttribute("dat2", all2);
        model.addAttribute("dat3", all3);


        model.addAttribute("candidate",new Candidate());
        model.addAttribute("view", "Decisions");
        return "layout";
    }


}
