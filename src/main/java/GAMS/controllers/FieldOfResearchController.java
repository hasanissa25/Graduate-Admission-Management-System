package GAMS.controllers;

import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Professor;
import GAMS.Crudrepository.FieldOfResearchRepo;

import GAMS.Crudrepository.EndUserRepo;
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

        FieldOfResearch temp = researchRepository.findByName(research.getName());
        if (temp == null){
            if (research.getProfessor()==null){
                research.setProfessor(new Professor(user.getUsername(),user.getPassword(),user.getConfPassword(),null));
            }

            if (research.getStudents() == null){
                research.setStudents(new ArrayList<EndUser>());
            }

            research.activate();
            researchRepository.save(research);
            return "redirect:fieldOfResearch";
        }else{

            model.addAttribute("research",new FieldOfResearch());
            model.addAttribute("view","createFOR");
            return "layout";
        }

    }

    @GetMapping("/fieldOfResearch")
    public String listResearch(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        EndUser user = userRepository.findByUsername(auth.getName());
        Iterable<FieldOfResearch> all = researchRepository.findAll();
        if(auth instanceof AnonymousAuthenticationToken || user.getRoleValue().equals("STUDENT")){
            List<FieldOfResearch> active = new ArrayList<>();
            for(FieldOfResearch research : all){
                if(research.isActive()){
                    active.add(research);
                }
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
        EndUser user = userRepository.findByUsername(auth.getName());

        FieldOfResearch temp = researchRepository.findByName(joinResearch.getName());
        temp.addStudent(user);
        researchRepository.save(temp);

        return "redirect:fieldOfResearch";
    }
}
