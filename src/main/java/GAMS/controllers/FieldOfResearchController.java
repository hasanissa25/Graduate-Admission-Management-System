package GAMS.controllers;

import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Professor;
import GAMS.Crudrepository.FieldOfResearchRepo;
import GAMS.Crudrepository.EndUserRepo;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class FieldOfResearchController {

    @Autowired
    FieldOfResearchRepo researchRepository;

    @Autowired
    private EndUserRepo userRepository;

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/createFOR")
    public String create(Model model) {

        model.addAttribute("research",new FieldOfResearch());
        model.addAttribute("view", "createFOR");
        return "layout";
    }

    @PostMapping("/createFOR")
    public String create(@ModelAttribute FieldOfResearch research, Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        EndUser user = userRepository.findByUsername(auth.getName());

        research.setProfessor(new Professor(research.getEmailAddress(),user.getUsername(),user.getPassword(),user.getConfPassword(),null));

        research.setStudents(new ArrayList<EndUser>());

        research.activate();
        researchRepository.save(research);
        return "redirect:fieldOfResearch";

    }

    @GetMapping("/fieldOfResearch")
    public String listResearch(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        EndUser user = userRepository.findByUsername(auth.getName());
        Iterable<FieldOfResearch> all = researchRepository.findAll();
        if(auth instanceof AnonymousAuthenticationToken || user.getRoleValue().equals("STUDENT")){
            List<FieldOfResearch> active = new ArrayList<>();
            for(FieldOfResearch research : all){

                    active.add(research);

            }
            model.addAttribute("research", active);
            model.addAttribute("view", "fieldOfResearch");
            return "layout";
        }
        else{
            model.addAttribute("research", all);
            model.addAttribute("view", "fieldOfResearch");
            return "layout";
        }
    }

    @PostMapping("/delete")
    public String deleteResearch(Model model, FieldOfResearch deleteresearch){

        FieldOfResearch temp = researchRepository.findByName(deleteresearch.getName());

        researchRepository.delete(temp);

        return "redirect:fieldOfResearch";
    }

    @PostMapping("/select")
    public String selectResearch(Model model, FieldOfResearch joinResearch){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentRepo.findByUsername(auth.getName());
        if(student == null) {
            EndUser endUser = userRepository.findByUsername(auth.getName());
            student = new Student(endUser.getUsername(), endUser.getPassword(), endUser.getConfPassword());
            userRepository.delete(endUser);
        }

        FieldOfResearch temp = researchRepository.findByName(joinResearch.getName());
        temp.addStudent(student);
        researchRepository.save(temp);

        student.setHasFOR(true);
        userRepository.save(student);

        return "redirect:fieldOfResearch";
    }
}
