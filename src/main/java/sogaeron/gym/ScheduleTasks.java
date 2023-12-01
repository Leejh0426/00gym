package sogaeron.gym;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.model.Reservation;
import sogaeron.gym.service.GymStatusService;
import sogaeron.gym.service.ReservationService;

@Component
public class ScheduleTasks {

   @Autowired
    GymStatusService gymStatusService;

    @Scheduled(fixedRate = 30000) // 30초에 한번씩
    public void task(){
        gymStatusService.changeCond();
            }


}
