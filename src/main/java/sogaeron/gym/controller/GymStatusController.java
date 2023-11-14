package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.controller.DTO.FindGymStatusDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.service.GymStatusService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class GymStatusController {

    final
    GymStatusService gymStatusService;

    public GymStatusController(GymStatusService gymStatusService) {
        this.gymStatusService = gymStatusService;
    }

    /**
     * 체육관 ID와 날짜를 이용하여 해당체육관의 그날짜에 사용할수있는 시간대를 표시한다.
     */
    @GetMapping("/gymstatus")
    public List<GymStatus> findGymStatus(@RequestParam Long id, @RequestParam@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")LocalDateTime time){
        FindGymStatusDTO findGymStatusDTO = new FindGymStatusDTO(id,time);
        System.out.println(findGymStatusDTO.getId());
        System.out.println(findGymStatusDTO.getTime());
        List<GymStatus> gymStatuses = gymStatusService.findGymStatus(findGymStatusDTO);
        return gymStatuses;
    }

}
