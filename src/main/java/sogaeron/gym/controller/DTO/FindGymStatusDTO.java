package sogaeron.gym.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
/**
 * 프론트에서 백엔드의 GymStatusController로 넘겨주는 데이터를 객체로 매핑하기 위한 클래스
 */
public class FindGymStatusDTO {

    private Long id;
    private LocalDateTime time;

}
