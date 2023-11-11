package sogaeron.gym.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@Setter
public class CheckReservationDTO {


    private Long reservationId;

    private LocalDateTime reservationDate;

    private int reservationNumber;

    private LocalDateTime dateTime;




}
