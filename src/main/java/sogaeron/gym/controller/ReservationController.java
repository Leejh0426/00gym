package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.controller.DTO.TestReservationDTO;
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
    public void testreservation(@ModelAttribute TestReservationDTO reservation){
        System.out.println(reservation.getReservationNumber() +"////////////" + reservation.getCondTime());
        reservationService.testreservation(reservation);

    }

}
