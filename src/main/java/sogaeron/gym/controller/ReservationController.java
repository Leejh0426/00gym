package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.controller.DTO.CheckReservationDTO;
import sogaeron.gym.controller.DTO.ReservationDTO;
import sogaeron.gym.controller.DTO.TestReservationDTO;
import sogaeron.gym.model.Reservation;
import sogaeron.gym.service.ReservationService;

import java.util.List;

@RestController
public class ReservationController {

    final
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    /**
     * 예약하기
     */
    @PostMapping("/reservation")
    public String reservation(@RequestBody ReservationDTO reservationDTO){
        String result = reservationService.doreservation(reservationDTO);

        return result;

    }

    /**
     * 예약조회
     */
    @GetMapping("/reservation")
    public List<CheckReservationDTO> checkReservation(){
        List<CheckReservationDTO> allReservation = reservationService.checkReservation();
        return allReservation;
    }

    /**
     * 예약삭제
     */

    @DeleteMapping("/reservation/{reservationId}")
    public String deleteReservation(@PathVariable Long reservationId){
        reservationService.deleteReservation(reservationId);

        return "성공";
    }

   // @PostMapping("reservation")
    // public   만들어야함


/*
    @PostMapping("/testreservation")
    public void testreservation(@ModelAttribute TestReservationDTO reservation){
        System.out.println(reservation.getReservationNumber() +"////////////" + reservation.getCondTime());
        reservationService.testreservation(reservation);

    }
*/

}
