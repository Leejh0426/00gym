package sogaeron.gym.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArduinoCondDTO {

    private Long id;
    private boolean condValue;

    @Builder
    public ArduinoCondDTO(Long id, boolean condValue){
        this.id = id;
        this.condValue = condValue;
    }

}
