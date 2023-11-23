package sogaeron.gym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.controller.DTO.ArduinoCondDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.service.ArduinoService;

@RestController
public class ArduinoController {

    private final ArduinoService arduinoService;

    public ArduinoController(ArduinoService arduinoService) {
        this.arduinoService = arduinoService;
    }


    @GetMapping("/arduino_check")
    public ApiResponse<ArduinoCondDTO> arduino_check(@RequestParam Long id){
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
