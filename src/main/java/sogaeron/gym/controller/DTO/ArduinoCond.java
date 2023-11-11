package sogaeron.gym.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArduinoCond {

    private Long id;
    private boolean condValue;

    @Builder
    public ArduinoCond(Long id, boolean condValue){
        this.id = id;
        this.condValue = condValue;
    }

}
