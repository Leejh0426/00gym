package sogaeron.gym.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@Setter
/**
 * 백엔드의 ReservationController에서 프론트엔드로 넘겨주는 데이터를 객체로 매핑하기 위한 클래스
 */
public class CheckReservationDTO {


    private Long reservationId;

    private LocalDateTime reservationDate;

    private int reservationNumber;

    private LocalDateTime dateTime;




}
