package GAMS.GAMS.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicantController {

    @GetMapping(path = "/app")
    public String getAppView() {
        return "app";
    }
}
