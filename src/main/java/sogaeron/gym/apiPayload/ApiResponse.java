package sogaeron.gym.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sogaeron.gym.apiPayload.code.BaseCode;
import sogaeron.gym.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
/**
 * API 응답 통일 관련 클래스
 */
public class ApiResponse<T> {

    @JsonProperty("isSuccess") // key값을 매핑시켜준다.
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)  //json으로 변환할 때 null값은 제외한다.
    private T result;

    // 제너릭 메서드 <T> 는 클래스의 <T>보다 메서드에서 우선시된다.
    // 일반적으로 매개변수를 통해 유츄가능하기에 호출할때 생략할 수 있다.


    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(),result);
    }


    public static <T> ApiResponse<T> of(BaseCode code, T result){  //왜 code를 .getReasonHttpstatus로 객체로 만들어서 저렇게 해야됨?
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(),result);


    }



    //실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(false, code, message, data);
    }



}