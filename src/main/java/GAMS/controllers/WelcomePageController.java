package GAMS.controllers;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.Servicelayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomePageController{

    @Autowired
    private UserService userService;


    @Autowired
    private EndUserRepo userRepository;

    @RequestMapping("/")
    public String welcome(HttpServletResponse response, Model model){

        model.addAttribute("view", "index");
        return "layout";
    }
}
