package sogaeron.gym.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import sogaeron.gym.apiPayload.ApiResponse;
import sogaeron.gym.controller.DTO.ArduinoCondDTO;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.service.ArduinoService;
import sogaeron.gym.service.GymService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Slf4j
@RestController
/**
 * 브라우저 상의 웹클라이언트의 아두이노 정보 관련 요청 및 응답을 처리하는 클래스
 */
public class ArduinoController {

    /**
     * 의존성 주입
     */
    private final ArduinoService arduinoService;
    final
    GymService gymService;

    public ArduinoController(ArduinoService arduinoService, GymService gymService) {
        this.arduinoService = arduinoService;
        this.gymService = gymService;
    }


    /**
     * 아두이누 cond value 조회
     */
    @GetMapping("/arduino_check")
    public ApiResponse<ArduinoCondDTO> arduino_check(@RequestParam Long id){
        gymService.CheckGymId(id);
        GymStatus gymStatus = arduinoService.arduino_check(id);

        if(gymStatus!=null) {
            ArduinoCondDTO arduinoCondDTO = ArduinoCondDTO.builder()
                    .id(gymStatus.getId())
                    .condValue(gymStatus.isCondValue())
                    .build();

            return ApiResponse.onSuccess(arduinoCondDTO) ;
        }
        else{
            ArduinoCondDTO arduinoCondDTO = ArduinoCondDTO.builder()
                    .id(id)
                    .condValue(false)
                    .build();

            return ApiResponse.onSuccess(arduinoCondDTO) ;
        }

    }

    /**
     * 컴퓨터 네트워크 수업용 API (임시 ) - 준호,태규
     */

    @GetMapping("/test")
    public String test(
                       HttpMethod httpMethod,
                       Locale locale,
                       @RequestHeader MultiValueMap<String, String> headerMap,
                       @RequestHeader("host") String host,
                       @CookieValue(value = "myCookie", required = false) String cookie) {


        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        return "성공";

    }

    /**
     * 컴퓨터 네트워크 수업용 API (임시 ) - 경원,정원
     */
    @GetMapping("/test1")
    public String test() {
        return "Hello, world!";
    }

}
