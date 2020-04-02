package GAMS.controllers;

import GAMS.Crudrepository.*;
import GAMS.entity.Candidate;
import GAMS.entity.Email;
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
import java.util.*;

@Controller
public class CandidatesController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private EmailRepo emailRepo;


    @GetMapping("/StudentCandidate")
    public String createit(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String profName = auth.getName();

        Iterable<Email> allEmailsToProf = emailRepo.findAllByToField(profName);

        List<Student> allStudentsApplied = new ArrayList<>();

        for(Email email : allEmailsToProf) {
            Student student = studentRepo.findByUsername(email.getFromField());
            allStudentsApplied.add(student);
        }

        model.addAttribute("dat2", allStudentsApplied);
        model.addAttribute("candidate",new Candidate());
        model.addAttribute("view", "StudentCandidates");
        return "layout";
    }

    @PostMapping("/StudentCandidate")
    public String saveEmployeee(@ModelAttribute Candidate candidate, Model model) {

        candidateRepo.save(candidate);

        return "redirect:StudentCandidate";

    }

}
