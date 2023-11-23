package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.GymRepository;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.apiPayload.code.status.ErrorStatus;
import sogaeron.gym.apiPayload.exception.handler.ErrorHandler;
import sogaeron.gym.model.Gym;

import java.util.List;

/**
 * 풋살장 관련 비즈니스 로직을 처리하는 클래스
 */
@Service
public class GymService {

    /**
     * 의존성주입
     */
    final
    GymRepository gymRepository;

    final
    GymStatusRepository gymStatusRepository;

    public GymService(GymRepository gymRepository, GymStatusRepository gymStatusRepository) {
        this.gymRepository = gymRepository;
        this.gymStatusRepository = gymStatusRepository;
    }


    /**
     * 예외처리) GymId가 유효한지 확인한다.
     */
    @Transactional
    public void CheckGymId(Long id){
        if(gymRepository.findById(id).isEmpty()){
            throw new ErrorHandler(ErrorStatus._GYM_ID_NOT_FOUND);
        }
    }

    /**
     * location을 통해 유효한 gym들을 찾는다.
     */
    public List<Gym> findGym(String location) {
        List<Gym> gyms = gymRepository.findBylocation(location);
        return gyms;

    }

}
