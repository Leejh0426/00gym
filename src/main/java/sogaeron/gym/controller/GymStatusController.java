package sogaeron.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.controller.DTO.FindGymStatusDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.service.GymService;
import sogaeron.gym.service.GymStatusService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
/**
 *브라우저 상의 웹클라이언트의 시간대별 풋살장 정보 관련 요청 및 응답을 처리하는 클래스
 */
public class GymStatusController {


    /**
     * 의존성 주입
     */
    final
    GymStatusService gymStatusService;

    final
    GymService gymService;

    public GymStatusController(GymStatusService gymStatusService, GymService gymService) {
        this.gymStatusService = gymStatusService;
        this.gymService = gymService;
    }


    /**
     * 선택된 풋살장의 시간대별 현 예약인원/  수용가능 인원 조회
     */
    @GetMapping("/gymstatus")
    public ApiResponse<List<GymStatus>> findGymStatus(@RequestParam Long id, @RequestParam@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")LocalDateTime time){

        gymService.CheckGymId(id);
        FindGymStatusDTO findGymStatusDTO = new FindGymStatusDTO(id,time);
        List<GymStatus> gymStatuses = gymStatusService.findGymStatus(findGymStatusDTO);

        return ApiResponse.onSuccess(gymStatuses);
    }

}
