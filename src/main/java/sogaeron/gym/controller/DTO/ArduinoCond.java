package sogaeron.gym.controller.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArduinoCond {

    private Long id;
    private int condValue;

    @Builder
    public ArduinoCond(Long id, int condValue){
        this.id = id;
        this.condValue = condValue;
    }

}
