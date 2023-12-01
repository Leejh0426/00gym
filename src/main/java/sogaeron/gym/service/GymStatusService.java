package sogaeron.gym.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.apiPayload.code.status.ErrorStatus;
import sogaeron.gym.apiPayload.exception.handler.ErrorHandler;
import sogaeron.gym.controller.DTO.FindGymStatusDTO;
import sogaeron.gym.model.GymStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 시간대 별 풋살장 현황 관련 비즈니스 로직을 처리하는 클래스
 */
@Service
public class GymStatusService {

    /**
     * 의존성주입
     */
    final
    GymStatusRepository gymStatusRepository;

    public GymStatusService(GymStatusRepository gymStatusRepository) {
        this.gymStatusRepository = gymStatusRepository;
    }


    /**
     *예외처리) GymstatusId가 유효한지 확인한다.
     */
    @Transactional
    public void CheckGymStatusId(Long id){
        if(gymStatusRepository.findById(id).isEmpty()){
            throw new ErrorHandler(ErrorStatus._GYMSTATUS_ID_NOT_FOUND);
        }
    }


    /**
     * 체육관 ID와 날짜를 이용하여 해당체육관의 그날짜에 사용할수있는 시간대를 표시한다.
     */
    public List<GymStatus> findGymStatus(FindGymStatusDTO findGymStatusDTO) {
        Long id = findGymStatusDTO.getId();
        LocalDateTime start = findGymStatusDTO.getTime().minusDays(1);
        LocalDateTime newstart = LocalDateTime.of(start.getYear(),start.getMonth(),start.getDayOfMonth(),23,59,59);
        LocalDateTime end = findGymStatusDTO.getTime().plusDays(1);
        LocalDateTime newend = LocalDateTime.of(end.getYear(),end.getMonth(),end.getDayOfMonth(),0,0,0);



        List<GymStatus> gymStatuses = gymStatusRepository.findByGym_IdAndDateTime(id,newstart,newend);

        System.out.println(gymStatuses.stream().toList());
        return gymStatuses;
    }

    /**
     * 타이머 (예약시간-10분) < 현재시간 < (예약시간 + 1hr) 이면 condvalue 값을 1로 수정
     */
    @Transactional
    public void changeCond() {

        List<GymStatus> gymstatuses = gymStatusRepository.findAll();

        for(int i=0;i<gymstatuses.size();i++){
            GymStatus gymStatus = gymstatuses.get(i);

            if((gymStatus.getRemainder() != gymStatus.getTotalNumber())
            && (gymStatus.getDateTime().minusMinutes(10).isBefore(LocalDateTime.now()))
                    &&(gymStatus.getDateTime().plusHours(1).isAfter(LocalDateTime.now())))
            {
                gymStatus.setCondValue(true);
                System.out.println(gymStatus.isCondValue());
            }
        }


    }





}
