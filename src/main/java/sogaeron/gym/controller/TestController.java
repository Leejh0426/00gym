package sogaeron.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String ttest(){
        return "00gym.html";
    }
}
