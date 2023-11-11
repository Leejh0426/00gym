package sogaeron.gym.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
public class FindGymStatusDTO {

    private Long id;
    private LocalDateTime time;

}
