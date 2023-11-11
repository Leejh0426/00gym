package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.model.Gym;
import sogaeron.gym.service.GymService;

import java.util.HashMap;
import java.util.List;

@RestController
public class GymController {

    final  GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }


    /**
     * 지역에 맞는 체육관들을 다 불러온다.
     */
    @GetMapping("/gym")
    public List<Gym> findGym(@RequestBody HashMap<String,Object> map){
        List<Gym> gyms = gymService.findGym((String) map.get("location"));
        return gyms;
    }



}
