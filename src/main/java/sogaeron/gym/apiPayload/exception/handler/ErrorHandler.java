package sogaeron.gym.apiPayload.exception.handler;

import sogaeron.gym.apiPayload.code.BaseErrorCode;
import sogaeron.gym.apiPayload.exception.GeneralException;

/**
 * 예외 처리 관련 클래스(핸들러)
 */
public class ErrorHandler extends GeneralException{
    public ErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
