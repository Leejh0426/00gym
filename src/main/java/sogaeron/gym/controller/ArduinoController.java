package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sogaeron.gym.controller.DTO.ArduinoCond;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.model.Reservation;
import sogaeron.gym.service.ArduinoService;

import static org.hibernate.criterion.Projections.id;

@RestController
public class ArduinoController {

    private final ArduinoService arduinoService;

    public ArduinoController(ArduinoService arduinoService) {
        this.arduinoService = arduinoService;
    }


    @GetMapping("/arduino_check")
    public ArduinoCond arduino_check(@RequestParam Long id){
        GymStatus gymStatus = arduinoService.arduino_check(id);

        if(gymStatus!=null) {
            ArduinoCond arduinoCond = ArduinoCond.builder()
                    .id(gymStatus.getId())
                    .condValue(gymStatus.isCondValue())
                    .build();

            return arduinoCond;
        }
        else{
            ArduinoCond arduinoCond = ArduinoCond.builder()
                    .id(id)
                    .condValue(false)
                    .build();

            return arduinoCond;
        }

    }

}
