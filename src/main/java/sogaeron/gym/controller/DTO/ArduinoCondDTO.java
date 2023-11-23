package sogaeron.gym.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
/**
 * 백엔드의 ArduinoController에서 프론트엔드로 넘겨주는 데이터를 객체로 매핑하기 위한 클래스
 */
public class ArduinoCondDTO {

    private Long id;
    private boolean condValue;

    @Builder
    public ArduinoCondDTO(Long id, boolean condValue){
        this.id = id;
        this.condValue = condValue;
    }

}
