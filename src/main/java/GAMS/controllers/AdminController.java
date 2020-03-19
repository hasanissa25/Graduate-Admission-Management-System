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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private FieldOfResearchRepo fieldOfResearchRepo;

    @GetMapping("/sendEmail/{id}")
    public String sendEmailToProfessor(@PathVariable(value = "id") Long studentId, Model model) {


        Student student = studentRepo.findById(studentId);

        List<FieldOfResearch> all = fieldOfResearchRepo.findAll();
        FieldOfResearch fieldOfResearchFound = null;

        //go over the field research data
        //each research has students

        //find the student based on the student id that iretrieved from the HTML
        //once we find it then we know that student belong to that particular professor
        for (FieldOfResearch fieldOfResearch : all) {
            ArrayList<EndUser> students = fieldOfResearch.getStudents();
            for (EndUser user : students) {

                if (user.getId().equals(studentId)) {

                    fieldOfResearchFound = fieldOfResearch;
                    break;
                }
            }
        }
        model.addAttribute("view", "StudentData");

        //if we did professor found
        if(fieldOfResearchFound!=null){
            try {
                String message = "The student " + student.getUsername() + " is interested in the research: "+ fieldOfResearchFound.getName();
                message = message + " CV:" + student.getCv() + " , Diploma:" + student.getDiploma() + " , Grade:" + student.getGradeAudit();

                emailService.sendSimpleMessage(fieldOfResearchFound.getProfessor().getEmailAddress(), "test@gmail.com", "Student Interest in your research", message);

                return "redirect:/StudentData?message=Email Sent to :" + fieldOfResearchFound.getProfessor().getEmailAddress();
            } catch (Exception e) {
                e.printStackTrace();
                //leave the exception for now.
            }
        }

        return "redirect:/StudentData?message=Email not sent.";

    }



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
