package sogaeron.gym.controller;

import org.springframework.web.bind.annotation.*;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.controller.DTO.CheckReservationDTO;
import sogaeron.gym.controller.DTO.ReservationDTO;
import sogaeron.gym.service.GymStatusService;
import sogaeron.gym.service.ReservationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
/**
 * 브라우저 상의 웹클라이언트의 예약 관련 요청 및 응답을 처리하는 클래스
 */
public class ReservationController {

    /**
     * 의존성 주입
     */
    final
    ReservationService reservationService;
    GymStatusService gymStatusService;

    public ReservationController(ReservationService reservationService, GymStatusService gymStatusService) {
        this.reservationService = reservationService;
        this.gymStatusService = gymStatusService;
    }


    /**
     * 예약하기
     */
    @PostMapping("/reservation")
    public ApiResponse<String> reservation(@Valid @RequestBody ReservationDTO reservationDTO){

        gymStatusService.CheckGymStatusId(reservationDTO.getGymStatusId());
        reservationService.CheckReservationNumber(reservationDTO);

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
        reservationService.CheckReservationId(reservationId);
        reservationService.deleteReservation(reservationId);
        return ApiResponse.onSuccess("성공");
    }


}
