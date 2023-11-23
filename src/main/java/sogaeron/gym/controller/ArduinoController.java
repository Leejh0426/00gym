package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.controller.DTO.ArduinoCondDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.service.ArduinoService;
import sogaeron.gym.service.GymService;

@RestController
/**
 * 브라우저 상의 웹클라이언트의 아두이노 정보 관련 요청 및 응답을 처리하는 클래스
 */
public class ArduinoController {

    /**
     * 의존성 주입
     */
    private final ArduinoService arduinoService;
    final
    GymService gymService;

    public ArduinoController(ArduinoService arduinoService, GymService gymService) {
        this.arduinoService = arduinoService;
        this.gymService = gymService;
    }


    /**
     * 아두이누 cond value 조회
     */
    @GetMapping("/arduino_check")
    public ApiResponse<ArduinoCondDTO> arduino_check(@RequestParam Long id){
        gymService.CheckGymId(id);
        GymStatus gymStatus = arduinoService.arduino_check(id);

        if(gymStatus!=null) {
            ArduinoCondDTO arduinoCondDTO = ArduinoCondDTO.builder()
                    .id(gymStatus.getId())
                    .condValue(gymStatus.isCondValue())
                    .build();

            return ApiResponse.onSuccess(arduinoCondDTO) ;
        }
        else{
            ArduinoCondDTO arduinoCondDTO = ArduinoCondDTO.builder()
                    .id(id)
                    .condValue(false)
                    .build();

            return ApiResponse.onSuccess(arduinoCondDTO) ;
        }

    }

}
