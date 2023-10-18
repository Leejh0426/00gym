package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.ReservationRepository;
import sogaeron.gym.model.Gym;
import sogaeron.gym.model.Reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


    @Transactional
    public void changeCond() {

        LocalDateTime start = LocalDateTime.now().minusMinutes(11);
        LocalDateTime end = LocalDateTime.now().plusMinutes(11);



        List<Reservation> reservations = reservationRepository.findCondTimeBetween(start,end);

        for(Reservation reservation : reservations){
            System.out.println(reservation.getCondValue());
            reservation.setCondValue(1);
            System.out.println(reservation.getCondValue());
        }



    }
    @Transactional
    public void testreservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
