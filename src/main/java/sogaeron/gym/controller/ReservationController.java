package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sogaeron.gym.model.Reservation;
import sogaeron.gym.service.ReservationService;

@RestController
public class ReservationController {

    final
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation")
    public String reservation(){
        return "reservation";
    }

    @PostMapping("/testreservation")
    public void testreservation(@ModelAttribute Reservation reservation){
        reservationService.testreservation(reservation);
    }

}
