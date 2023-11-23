package sogaeron.gym.apiPayload.code;

/**
 * 예외 처리 관련 클래스
 */
public interface BaseErrorCode {

    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}