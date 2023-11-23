package sogaeron.gym.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sogaeron.gym.apiPayload.code.BaseErrorCode;
import sogaeron.gym.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
/**
 * 예외 처리 관련 클래스
 */
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
