package GAMS.controllers;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.EndUser;
import GAMS.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @Autowired
    EndUserRepo userRepository;

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

        if(endUser == null){
            // This is an error because the student is supposed to exist in DB (to be handled later)
//            if(user.getPassword().equals(user.getConfPassword())){
//
//                user.setPassword(passwordEncoder.encode(user.getPassword()));
//                user.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
//                userRepository.save(user);
//                return "redirect:login";
//            }
//            else{
//                model.addAttribute("view", "registration");
//                model.addAttribute("pwError", true);
//                return "layout";
//            }

            model.addAttribute("view", "index");
            return "layout";
        }
        else{
            formStudent.setConfPassword(endUser.getConfPassword());
            formStudent.setPassword(endUser.getPassword());
            formStudent.setUsername(endUser.getUsername());
            formStudent.setRole(endUser.getRole());

            studentRepo.save(formStudent);

            model.addAttribute("view", "index");
            return "layout";
        }

    }

    @GetMapping("/studentStatus")
    public String studentStatus(Model model, HttpServletRequest request) {

        model.addAttribute("student", new Student());
        model.addAttribute("view", "studentStatus");
        return "layout";

    }

}