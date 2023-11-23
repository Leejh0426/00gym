package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.Repository.ReservationRepository;
import sogaeron.gym.model.GymStatus;
import sogaeron.gym.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

/**
 * 아두이노 관련 비즈니스 로직을 처리하는 클래스
 */
@Service
public class ArduinoService {

    /**
     * 의존성주입
     */
    final
    GymStatusRepository gymStatusRepository;

    public ArduinoService(GymStatusRepository gymStatusRepository) {
        this.gymStatusRepository = gymStatusRepository;
    }

    /**
     * 채육관 id가 일치, condvalue값이 1, 그리고 시간대가 일치하는 요청이 있는지 GymStatusRepository에서 찾아서 있으면 GymStatus객체를 반환해준다.
     */
    public GymStatus arduino_check(Long id) {
        List<GymStatus> gymstatuses = gymStatusRepository.findByGym_IdAndCondValue(id, true);

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(10);

        if(gymstatuses!=null){
            for(int i=0;i<gymstatuses.size();i++){
                LocalDateTime dateTime = gymstatuses.get(i).getDateTime();
                if(dateTime.isAfter(start) && dateTime.isBefore(end)){
                    return gymstatuses.get(i);
                }
            }
        }


        return null;

    }

}
