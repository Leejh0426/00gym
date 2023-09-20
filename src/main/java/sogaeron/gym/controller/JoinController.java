package sogaeron.gym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {


    @GetMapping("/join")
    public String join(){
        return "join";
    }
}
