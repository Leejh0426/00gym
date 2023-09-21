package sogaeron.gym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPageController {

    @GetMapping("/mypage")
    public String mypage(){
        return "mypage";
    }
}
