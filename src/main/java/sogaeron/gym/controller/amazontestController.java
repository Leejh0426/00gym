package sogaeron.gym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class amazontestController {

    @GetMapping("/test")
    public String test(){
        System.out.println("안녕?");
        return "dotest.html";
    }
}
