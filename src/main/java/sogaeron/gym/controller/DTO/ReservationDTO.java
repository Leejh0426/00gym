package sogaeron.gym.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
public class ReservationDTO {
    private Long gymStatusId;
    private int reservationNumber;

}
