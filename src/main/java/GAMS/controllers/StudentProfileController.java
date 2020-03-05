package GAMS.controllers;

import GAMS.Crudrepository.EndUserRepo;
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
public class StudentProfileController {

    @Autowired
    EndUserRepo userRepository;

    @GetMapping("/studentProfile")
    public String studentProfile(Model model, HttpServletRequest request) {

        model.addAttribute("student", new Student());
        model.addAttribute("view", "studentProfile");
        return "layout";

    }

    @PostMapping("/studentProfile")
    public String register(@ModelAttribute Student formStudent, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = (Student) userRepository.findByUsername(auth.getName());

        if(student == null){
            // This is an error because the student is supposed to exist in DB
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
            student.setCv(formStudent.getCv());
            student.setDiploma(formStudent.getDiploma());
            student.setEmail(formStudent.getEmail());
            student.setGradeAudit(formStudent.getGradeAudit());

            userRepository.save(student);

            model.addAttribute("view", "index");
            return "layout";
        }

    }
}