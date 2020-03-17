package GAMS.controllers;

import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private StudentRepo studentRepo;


    @GetMapping("/StudentData")
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Iterable<Student> all = studentRepo.findAll();

        model.addAttribute("dat",all);

        model.addAttribute("view", "StudentData");
        return "layout";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Student student = studentRepo.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("dat", student);

        theModel.addAttribute("view", "StudentData");
        return "layout";
    }




}
