package sogaeron.gym.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
/**
 * 프론트에서 백엔드의 ReservationController로 넘겨주는 데이터를 객체로 매핑하기 위한 클래스
 */
public class ReservationDTO {

    @NotNull
    private Long gymStatusId;
    @NotNull
    private int reservationNumber;

}
