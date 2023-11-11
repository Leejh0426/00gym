package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.GymStatusRepository;
import sogaeron.gym.controller.DTO.FindGymStatusDTO;
import sogaeron.gym.model.GymStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GymStatusService {

    final
    GymStatusRepository gymStatusRepository;

    public GymStatusService(GymStatusRepository gymStatusRepository) {
        this.gymStatusRepository = gymStatusRepository;
    }

    public List<GymStatus> findGymStatus(FindGymStatusDTO findGymStatusDTO) {
        Long id = findGymStatusDTO.getId();
        LocalDateTime start = findGymStatusDTO.getTime().minusDays(1);
        LocalDateTime newstart = LocalDateTime.of(start.getYear(),start.getMonth(),start.getDayOfMonth(),23,59,59);
        LocalDateTime end = findGymStatusDTO.getTime().plusDays(1);
        LocalDateTime newend = LocalDateTime.of(end.getYear(),end.getMonth(),end.getDayOfMonth(),0,0,0);

        System.out.println(newstart);
        System.out.println(newend);

        List<GymStatus> gymStatuses = gymStatusRepository.findByGym_IdAndDateTime(id,newstart,newend);
        return gymStatuses;
    }

    /**
     * 타이머
     */
    @Transactional
    public void changeCond() {

        List<GymStatus> gymstatuses = gymStatusRepository.findAll();

        for(int i=0;i<gymstatuses.size();i++){
            GymStatus gymStatus = gymstatuses.get(i);

            if((gymStatus.getRemainder() != gymStatus.getTotal_number())
            && (gymStatus.getDateTime().isAfter(LocalDateTime.now()))
                    &&(gymStatus.getDateTime().isBefore(LocalDateTime.now().plusMinutes(10))) )
            {

                gymStatus.setCondValue(true);
                System.out.println(gymStatus.isCondValue());
            }
        }


    }




}
