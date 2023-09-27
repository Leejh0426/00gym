package sogaeron.gym;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sogaeron.gym.model.Reservation;
import sogaeron.gym.service.ReservationService;

@Component
public class ScheduleTasks {

    final ReservationService reservationService;

    public ScheduleTasks(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Scheduled(fixedRate = 60000) // 1분에 한번씩
    public void task(){
        reservationService.changeCond();
    }
}
