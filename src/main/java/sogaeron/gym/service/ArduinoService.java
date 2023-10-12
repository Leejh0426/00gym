package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogaeron.gym.Repository.ReservationRepository;
import sogaeron.gym.model.Reservation;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Service
public class ArduinoService {

    private final ReservationRepository reservationRepository;

    public ArduinoService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation arduino_check(Long id) {
        Reservation reservation = reservationRepository.findByIdAndCondValue(id,1);

        //System.out.println(reservation.getCondTime());

        if(reservation!=null){
            return reservation;
        }

        return null;

    }
}
