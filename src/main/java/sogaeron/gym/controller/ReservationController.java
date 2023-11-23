package sogaeron.gym.controller;

import org.springframework.web.bind.annotation.*;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.controller.DTO.CheckReservationDTO;
import sogaeron.gym.controller.DTO.ReservationDTO;
import sogaeron.gym.service.ReservationService;

import java.util.ArrayList;
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
    public ApiResponse<String> reservation(@RequestBody ReservationDTO reservationDTO){
        String result = reservationService.doreservation(reservationDTO);

        return ApiResponse.onSuccess(result);

    }

    /**
     * 예약조회
     */
    @GetMapping("/reservation")
    public ApiResponse<List<CheckReservationDTO>> checkReservation(){
        List<CheckReservationDTO> allReservation = reservationService.checkReservation();
        return ApiResponse.onSuccess(allReservation);
    }

    /**
     * 예약삭제
     */

    @DeleteMapping("/reservation/{reservationId}")
    public ApiResponse<String> deleteReservation(@PathVariable Long reservationId){
        reservationService.deleteReservation(reservationId);
        return ApiResponse.onSuccess("성공");
    }


}
