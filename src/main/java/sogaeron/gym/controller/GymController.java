package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.model.Gym;
import sogaeron.gym.service.GymService;

import java.util.HashMap;
import java.util.List;

/**
 * 브라우저 상의 웹클라이언트의 풋살장 정보 관련 요청 및 응답을 처리하는 클래스
 */
@RestController
public class GymController {

    /**
     * 의존성 주입
     */
    final  GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }


    /**
     * 해당 지역 풋살장 목록 조회
     */
    @GetMapping("/gym")
    public ApiResponse<List<Gym>> findGym(@RequestParam String location){
        List<Gym> gyms = gymService.findGym(location);
        return ApiResponse.onSuccess(gyms);
    }



}
