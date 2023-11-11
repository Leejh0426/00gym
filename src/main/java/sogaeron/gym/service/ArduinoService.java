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

@Service
public class ArduinoService {


    final
    GymStatusRepository gymStatusRepository;

    public ArduinoService(GymStatusRepository gymStatusRepository) {
        this.gymStatusRepository = gymStatusRepository;
    }

    public GymStatus arduino_check(Long id) {
        List<GymStatus> gymstatuses = gymStatusRepository.findByGym_IdAndCondValue(id, true);

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(10);

        if(gymstatuses!=null){
            for(int i=0;i<gymstatuses.size();i++){
                LocalDateTime dateTime = gymstatuses.get(i).getDateTime();
                if(dateTime.isAfter(start) && dateTime.isBefore(end)){
                    System.out.println(gymstatuses.get(i).getId());
                    return gymstatuses.get(i);
                }
            }
        }


        return null;

    }

}
