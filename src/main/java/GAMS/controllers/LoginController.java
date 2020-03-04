package GAMS.controllers;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.Servicelayer.UserService;
import GAMS.entity.EndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private EndUserRepo userRepository;

    @Autowired
    private UserService userService;


    @GetMapping("/login-logout")
    public String loggedOut(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:logout";
        }

        model.addAttribute("user", new EndUser());
        model.addAttribute("view", "login");
        model.addAttribute("logout", true);
        return "layout";

    }
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            return "redirect:";
        }

        model.addAttribute("user", new EndUser());
        model.addAttribute("view", "login");
        return "layout";

    }

    @PostMapping("/login")
    public String login(Model model, HttpServletResponse response, @Valid EndUser user) {

        if (userService.authenticate(user.getUsername(), user.getPassword())) {
            model.addAttribute("view", "index");
            return "redirect:";

        } else {
            model.addAttribute("view", "login");
            return "layout";
        }
    }

        @GetMapping("/login-error")
       public String loginError(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:";
        }

        model.addAttribute("loginError", true);
        model.addAttribute("user", new EndUser());
        model.addAttribute("view", "login");
        return "layout";
    }


    }

