package sogaeron.gym.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import sogaeron.gym.apiPayload.code.BaseErrorCode;
import sogaeron.gym.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
/**
 * 예외 처리 관련 클래스
 */
public enum ErrorStatus implements BaseErrorCode {

    //가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다"),

    //Reservation 관련 에러
    _RESERVATIONNUMBER_NOT_EXCEED_REMAINDER(HttpStatus.BAD_REQUEST,"Reservation4001", "예약을 할려는 인원이 남은 인원보다 많습니다"),
    _Reservation_ID_NOT_FOUND(HttpStatus.BAD_REQUEST,"Reservation4002", " 유효하지 않은 ReservationId 입니다."),

    //GmStatus 관련 에러
    _GYMSTATUS_ID_NOT_FOUND(HttpStatus.BAD_REQUEST,"GymStatus4001", " 유효하지 않은 GymStatusId 입니다."),

    //Gym 관련 에러
    _GYM_ID_NOT_FOUND(HttpStatus.BAD_REQUEST,"Gym4001", " 유효하지 않은 GymId 입니다.");



    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}