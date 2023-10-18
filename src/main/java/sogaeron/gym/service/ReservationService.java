package sogaeron.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogaeron.gym.Repository.GymRepository;
import sogaeron.gym.Repository.ReservationRepository;
import sogaeron.gym.Repository.UserRepository;
import sogaeron.gym.controller.DTO.TestReservationDTO;
import sogaeron.gym.model.Gym;
import sogaeron.gym.model.Reservation;
import sogaeron.gym.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.time.LocalTime.now;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    GymRepository gymRepository;
    @Autowired
    UserRepository userRepository;


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
    public void testreservation(TestReservationDTO testReservationDTO) {


        Reservation reservation = new Reservation();

        System.out.println(testReservationDTO.getGymId());

        Optional<Gym> gym = gymRepository.findById(testReservationDTO.getGymId());
        Optional<User> user = userRepository.findById(testReservationDTO.getUserId());

        reservation.setReservationNumber(testReservationDTO.getReservationNumber());
        reservation.setReservationDate(testReservationDTO.getReservationDate());
        reservation.setUser(user.get());
        reservation.setGym(gym.get());
        reservation.setCondTime(testReservationDTO.getCondTime());
        reservation.setCondValue(0);

        reservationRepository.save(reservation);

    }
}
