package sogaeron.gym.apiPayload.code;

/**
 * API 응답 통일 관련 클래스
 */
public interface BaseCode {

    public ReasonDTO getReason();

    public ReasonDTO getReasonHttpStatus();
}