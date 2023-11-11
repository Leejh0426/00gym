package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sogaeron.gym.controller.DTO.FindGymStatusDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.service.GymStatusService;

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
    public List<GymStatus> findGymStatus(@RequestBody FindGymStatusDTO findGymStatusDTO){
        System.out.println(findGymStatusDTO.getId());
        System.out.println(findGymStatusDTO.getTime());
        List<GymStatus> gymStatuses = gymStatusService.findGymStatus(findGymStatusDTO);
        return gymStatuses;
    }

}
